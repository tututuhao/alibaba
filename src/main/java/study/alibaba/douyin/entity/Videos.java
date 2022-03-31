package study.alibaba.douyin.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 视频信息表
 * </p>
 *
 * @author lyh
 * @since 2022-04-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
public class Videos implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 发布者id
     */
    private String userId;

    /**
     * 用户使用音频的信息
     */
    private String audioId;

    /**
     * 视频描述
     */
    private String videoDesc;

    /**
     * 视频存放的路径
     */
    private String videoPath;

    /**
     * 视频秒数
     */
    private Float videoSeconds;

    /**
     * 视频宽度
     */
    private Integer videoWidth;

    /**
     * 视频高度
     */
    private Integer videoHeight;

    /**
     * 视频封面图
     */
    private String coverPath;

    /**
     * 喜欢/赞美的数量
     */
    private Long likeCounts;

    /**
     * 视频状态：
1、发布成功
2、禁止播放，管理员操作
     */
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 最后修改时间
     */
//    @TableField(fill = FieldFill.INSERT_UPDATE)
//    private Date updateTime;

//    @TableLogic(value = "1", delval = "0")
//    @TableField(fill = FieldFill.INSERT)
//    private Short isvalid;
}
