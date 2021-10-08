package ru.issuemanager.demo.config

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.web.servlet.MultipartConfigFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.util.unit.DataSize
import javax.servlet.MultipartConfigElement

@Configuration
@ComponentScan
@EnableAutoConfiguration
class FileConfig {
    @Bean
    fun multipartConfigElement(): MultipartConfigElement {
        val factory = MultipartConfigFactory().apply {
            this.setMaxFileSize(DataSize.ofKilobytes(128))
            this.setMaxRequestSize(DataSize.ofKilobytes(128))
        }
        return factory.createMultipartConfig()
    }
}