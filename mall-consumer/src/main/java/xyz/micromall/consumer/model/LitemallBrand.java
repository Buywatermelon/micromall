package xyz.micromall.consumer.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName(value = "litemall_brand")
public class LitemallBrand{

    @TableId(type = IdType.ASSIGN_UUID)
    private Integer id;

    private String name;

    private String desc;

    private String picUrl;

    private Integer sortOrder;

    private BigDecimal floorPrice;

    private LocalDateTime addTime;

    private LocalDateTime updateTime;

    private Boolean deleted;
}
