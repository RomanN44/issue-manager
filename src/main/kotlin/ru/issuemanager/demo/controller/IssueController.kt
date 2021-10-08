package ru.issuemanager.demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import ru.issuemanager.demo.service.IssueService

@RestController
class IssueController(
    val issueService: IssueService
) {
    @RequestMapping(value = ["/issues"], method = [RequestMethod.GET])
    fun getIssues() = issueService.getAll()

    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
    fun testApp() = "Hello Spring!"
}