package com.hh.hhclient.model;

import feign.Param;

public record GetVacancyParameters(
        @Param(value = "page")          int page,    /** С какой страницы начинать поиск **/
        @Param(value = "per_page")      int perPage, /** Количество элементов **/
        @Param(value = "text")          String text,         /** Поиск переданного текста по полям вакансии **/
        @Param(value = "excluded_text") String excludedText, /** Исключает переданный текст **/

        @Param(value = "professional_role") String professionalRole, /** Профессиональную область **/
        @Param(value = "employment_form")   String employmentForm,    /** Форма занятости **/
        @Param(value = "experience") String experience, /** Опыт работы **/
        @Param(value = "education")  String education,  /** Образование **/

        @Param(value = "work_format")   String workFormat,   /** Формат работы **/
        @Param(value = "working_hours") String workingHours, /** Рабочие часы **/
        @Param(value = "work_schedule_by_days") String workScheduleByDays, /** Рабочие дни **/

        @Param(value = "salary") Integer salary, /** Размер оплаты **/
        @Param(value = "salary_frequency") String salaryFrequency, /** Частоту выплат **/
        @Param(value = "salary_mode")      String salaryMode,      /** ?Гранулярность? зарплаты (чего указывает?) **/

        @Param(value = "label")    String label,    /** Метки по вакансии **/
        @Param(value = "area")     String area,     /** Регион **/
        @Param(value = "counters") String counters,/** Количество откликов на вакансии. Требуется для responseCountEnabled **/

        @Param(value = "date_from") String dateFrom, /** Диапазон ?снизу? даты публикации вакансии **/
        @Param(value = "date_to")   String dateTo,   /** Диапазон ?сверху? даты публикации вакансии **/

        @Param(value = "clusters") Boolean clusters, /** Возвращать ли кластеры **/
        @Param(value = "no_magic") Boolean noMagic,  /** Включить ли автоматическое преобразование вакансий **/
        @Param(value = "describe_arguments")     Boolean describeArguments,/** Возвращать ли описание параметров поиска **/
        @Param(value = "response_count_enabled") Boolean responseCountEnabled/** Учитывать ли количество откликов на вакансии из поля counters**/
        )
{}
