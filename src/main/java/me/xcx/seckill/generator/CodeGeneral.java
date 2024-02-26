package me.xcx.seckill.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

public class CodeGeneral {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql:///seckill", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("xcx") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .enableSpringdoc() // 开启 Springdoc 模式
//                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\develop\\2024\\work\\seckill\\src\\main\\java"); // 指定输出目录
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        // 自定义类型转换
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);

                }))
                .packageConfig(builder -> {
                    builder.parent("me.xcx.seckill") // 设置父包名
//                            .moduleName("") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\develop\\2024\\work\\seckill\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_user", "t_goods", "t_order", "t_seckill_goods", "t_seckill_order") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀

                    builder.entityBuilder()
                            .enableLombok()
                            .enableFileOverride();
                    // 控制层生成策略配置
                    builder.controllerBuilder()
//                            .enableRestStyle() // 控制器是否是RestController
                            .enableFileOverride(); // 开启文件覆盖

                    // mapper相关配置策略
                    builder.mapperBuilder()
                            .enableBaseResultMap()
                            .enableBaseColumnList()
                            .enableFileOverride();
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
