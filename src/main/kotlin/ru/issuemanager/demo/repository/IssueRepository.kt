package ru.issuemanager.demo.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.issuemanager.demo.model.Issue

interface IssueRepository: JpaRepository<Issue, Long> {
    override fun findAll(): MutableList<Issue>
}