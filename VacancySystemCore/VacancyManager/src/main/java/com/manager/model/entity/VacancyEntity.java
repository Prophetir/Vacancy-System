package com.manager.model.entity;

import com.contract.model.param.*;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

/**
 * Не могу реализовать сохранение вакансий в БД.
 * **/
@Entity
@Getter
public class VacancyEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "vacancy_id")
    private String vacancyId;

    @Column(name = "name")
    private String name;

    @Embedded
    private TypeDto type;

    @Column(name = "archived")
    private boolean archived;

    @Column(name = "url")
    private String url;

    @Embedded
    private ContactsDto contacts;

    @Embedded
    private SalaryDto salary;

    @Embedded
    private SalaryRangeDto salaryRange;

    @Embedded
    private WorkFormatDto workFormat;

    @Embedded
    private EmployerDto employer;

    @Embedded
    private AreaDto area;

    @Embedded
    private AddressDto address;

    @Column(name = "alternative_url")
    private String alternativeUrl;

    @Column(name = "response_url")
    private String responseUrl;

    @Column(name = "show_contacts")
    private boolean showContacts;

    @Column(name = "published_at")
    private Date publishedAt;

    @Column(name = "created_at")
    private Date createdAt;
}
