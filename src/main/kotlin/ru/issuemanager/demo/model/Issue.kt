package ru.issuemanager.demo.model

import javax.persistence.*

@Entity
@Table(name = "issue")
data class Issue(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_id")
    var id: Long? = null,
    @Column(name = "title")
    var title: String? = null,
    @Column(name = "description")
    var description: String? = null,
    @Column(name = "user")
    var user: String? = null
) {
}