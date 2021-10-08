package ru.issuemanager.demo.controller

import org.springframework.stereotype.Controller
import java.io.FileOutputStream
import java.io.BufferedOutputStream
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestMapping
import java.io.File
import java.lang.Exception

@Controller
class FileUploadController {
    @RequestMapping(value = ["/upload"], method = [RequestMethod.GET])
    @ResponseBody
    fun provideUploadInfo(): String {
        return "upload"
    }

    @RequestMapping(value = ["/upload"], method = [RequestMethod.POST])
    @ResponseBody
    fun handleFileUpload(
        @RequestParam("name") name: String,
        @RequestParam("file") file: MultipartFile
    ): String {
        return if (!file.isEmpty) {
            try {
                val bytes = file.bytes
                val stream = BufferedOutputStream(FileOutputStream(File("$name-uploaded")))
                stream.write(bytes)
                stream.close()
                "Вы удачно загрузили $name в $name-uploaded !"
            } catch (e: Exception) {
                "Вам не удалось загрузить " + name + " => " + e.message
            }
        } else {
            "Вам не удалось загрузить $name потому что файл пустой."
        }
    }
}