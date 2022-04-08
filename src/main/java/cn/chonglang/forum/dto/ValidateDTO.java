package cn.chonglang.forum.dto;

import lombok.Data;

/*       ├─cn.chonglang.forum         应用目录
               │  ├─controller         控制器目录
               │  ├─dto                数据传输层    <----------
               │  ├─provider           提供类
               │  ├─service            业务逻辑层
               │  ├─advice             异常处理
               │  ├─exception          自定义异常
               │  ├─dao                数据访问层
               │  ├─utils              工具类
               │__├─config             配置类
*/
/*        这个是对象类，用来装数据的

        从页面传过来一些数据

        就是先装到这个类里，然后才放到放到数据库

        起到一个中间介质的效果*/



@Data
public class ValidateDTO {
    private Integer socre;
    private Integer success;
    private String msg;
}
