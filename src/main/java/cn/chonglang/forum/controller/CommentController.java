package cn.chonglang.forum.controller;

import cn.chonglang.forum.dto.CommentDTO;
import cn.chonglang.forum.dto.CommentQueryDTO;
import cn.chonglang.forum.dto.QuestionDTO;
import cn.chonglang.forum.dto.UserDTO;
import cn.chonglang.forum.enums.CommentTypeEnum;
import cn.chonglang.forum.service.CommentService;
import cn.chonglang.forum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Value("${vaptcha.vid}")
    private String vaptcha_vid;
    @Autowired
    private QuestionService questionService;
    @GetMapping(value = {"/comment/{id}"})
    public String comment(@PathVariable(name = "id") Long id, HttpServletRequest request, Model model){

        UserDTO viewUser = (UserDTO)request.getAttribute("loginUser");
        if(viewUser==null){
            model.addAttribute("rsTitle", "您无权访问！");
            model.addAttribute("rsMessage", "高级回复页游客不可见，快去登录吧");
            return "result";
        }
        CommentDTO commentDTO;
        CommentQueryDTO commentQueryDTO = new CommentQueryDTO();
        commentQueryDTO.setId(id);
        commentQueryDTO.convert();
        List<CommentDTO> commentDTOs = commentService.list(commentQueryDTO).getData();
        if(commentDTOs.size()==1){
            commentDTO = commentDTOs.get(0);
        }else {
            model.addAttribute("rsTitle", "该页面无法访问！");
            model.addAttribute("rsMessage", "请确认路径是否正确");
            return "result";
        }
        List<CommentDTO> subComments = commentService.listByTargetId(id, CommentTypeEnum.COMMENT);
        QuestionDTO questionDTO = questionService.getById(commentDTO.getParentId(), viewUser.getId());
        model.addAttribute("question", questionDTO);
        model.addAttribute("comment", commentDTO);
        model.addAttribute("subComments", subComments);
        model.addAttribute("navtype", "communitynav");
        model.addAttribute("vaptcha_vid", vaptcha_vid);
        return "p/comment";
    }





/*
    @Autowired
    private CommentService commentService;
    @Autowired
    private BaiduCloudProvider baiduCloudProvider;

    @Deprecated
    @ResponseBody//@ResponseBody返回json格式的数据
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentCreateDTO commentCreateDTO,//@RequestBody接受json格式的数据
                       HttpServletRequest request) {

        UserDTO user = (UserDTO) request.getAttribute("loginUser");
        if (user == null) {
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }

        if (commentCreateDTO == null || StringUtils.isBlank(commentCreateDTO.getContent())) {
            return ResultDTO.errorOf(CustomizeErrorCode.CONTENT_IS_EMPTY);
        }
        ResultDTO resultDTO = baiduCloudProvider.getTextCensorReult(commentCreateDTO.getContent());
        if(resultDTO.getCode()!=1){
            return resultDTO;
        }

        Comment comment = new Comment();
        comment.setParentId(commentCreateDTO.getParentId());
        comment.setContent(commentCreateDTO.getContent());
        comment.setType(commentCreateDTO.getType());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        comment.setLikeCount(0L);
        UserAccount userAccount = new UserAccount();
        userAccount.setVipRank(user.getVipRank());
        userAccount.setGroupId(user.getGroupId());
        userAccount.setUserId(user.getId());
        commentService.insert(comment,user,userAccount);

       return ResultDTO.okOf("回复成功！");

    }

    @Deprecated
    @ResponseBody
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    public ResultDTO<List<CommentDTO>> comments(@PathVariable(name = "id") Long id) {
        List<CommentDTO> commentDTOS = commentService.listByTargetId(id, CommentTypeEnum.COMMENT);
        return ResultDTO.okOf(commentDTOS);
    }

    @Deprecated
    @PostMapping("/comment/del/id")
    @ResponseBody
    public Map<String,Object> deleteCommentById(HttpServletRequest request,
                                                     @RequestParam(name = "id",defaultValue = "0") Long id
                                                     ,@RequestParam(name = "type",defaultValue = "0") Integer type ) {

        UserDTO user = (UserDTO) request.getAttribute("loginUser");
        UserAccount userAccount = new UserAccount();
        userAccount.setVipRank(user.getVipRank());
        userAccount.setGroupId(user.getGroupId());
        userAccount.setUserId(user.getId());
        if (user == null||userAccount==null) {
            throw new CustomizeException(CustomizeErrorCode.NO_LOGIN);
        }
        Map<String,Object> map  = new HashMap<>();
        if(id==null||id==0||type==null||type==0) {
            map.put("code",500);
            map.put("msg","妈呀，出问题啦！");
        }
        else {
            int c = commentService.delCommentByIdAndType(user.getId(),userAccount.getGroupId(),id,type);
            if(c==0) {
                map.put("code",500);
                map.put("msg","哎呀，该评论已删除或您无权删除！");
            }
            else {
                map.put("code",200);
                map.put("msg","恭喜您，成功删除"+c+"条评论及子评论！");
            }
        }
        return map;
    }

*/
}
