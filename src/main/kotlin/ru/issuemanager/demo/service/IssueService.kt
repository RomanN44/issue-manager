package ru.issuemanager.demo.service

import org.springframework.stereotype.Service
import ru.issuemanager.demo.repository.IssueRepository

@Service
class IssueService(
    val issueRepository: IssueRepository
) {
    fun getAll() = issueRepository.findAll()
}