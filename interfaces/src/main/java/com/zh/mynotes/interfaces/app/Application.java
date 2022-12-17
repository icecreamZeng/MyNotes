package com.zh.mynotes.interfaces.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.SpringVersion;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Slf4j
@SpringBootApplication(scanBasePackages = {"com.zh.mynotes.*"})
@EnableWebMvc
public class Application {

    public static void main(String[] args) {
        AnsiOutput.setEnabled(AnsiOutput.Enabled.ALWAYS);
        new SpringApplicationBuilder(Application.class)
                .main(SpringVersion.class)
                .bannerMode(Banner.Mode.CONSOLE).run(args);

    }
}