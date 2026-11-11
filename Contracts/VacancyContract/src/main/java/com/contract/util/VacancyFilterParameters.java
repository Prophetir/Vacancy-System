package com.contract.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VacancyFilterParameters(
        @JsonProperty(value = "page")          int page,    /** С какой страницы начинать поиск **/
        @JsonProperty(value = "per_page")      int perPage, /** Количество элементов **/
        @JsonProperty(value = "text")          String text,         /** Поиск переданного текста по полям вакансии **/
        @JsonProperty(value = "excluded_text") String excludedText, /** Исключает переданный текст **/

        @JsonProperty(value = "professional_role") String professionalRole, /** Профессиональную область **/
        @JsonProperty(value = "employment_form")   String employmentForm,    /** Форма занятости **/
        @JsonProperty(value = "experience") String experience, /** Опыт работы **/
        @JsonProperty(value = "education")  String education,  /** Образование **/

        @JsonProperty(value = "work_format")   String workFormat,   /** Формат работы **/
        @JsonProperty(value = "working_hours") String workingHours, /** Рабочие часы **/
        @JsonProperty(value = "work_schedule_by_days") String workScheduleByDays, /** Рабочие дни **/

        @JsonProperty(value = "salary") Integer salary, /** Размер оплаты **/
        @JsonProperty(value = "salary_frequency") String salaryFrequency, /** Частоту выплат **/
        @JsonProperty(value = "salary_mode")      String salaryMode,      /** ?Гранулярность? зарплаты (чего указывает?) **/

        @JsonProperty(value = "label")    String label,    /** Метки по вакансии **/
        @JsonProperty(value = "area")     String area,     /** Регион **/
        @JsonProperty(value = "counters") String counters, /** Количество откликов на вакансии. Требуется для responseCountEnabled **/

        @JsonProperty(value = "date_from") String dateFrom, /** Диапазон ?снизу? даты публикации вакансии **/
        @JsonProperty(value = "date_to")   String dateTo,   /** Диапазон ?сверху? даты публикации вакансии **/

        @JsonProperty(value = "clusters") Boolean clusters, /** Возвращать ли кластеры **/
        @JsonProperty(value = "no_magic") Boolean noMagic,  /** Включить ли автоматическое преобразование вакансий **/
        @JsonProperty(value = "describe_arguments")     Boolean describeArguments,   /** Возвращать ли описание параметров поиска **/
        @JsonProperty(value = "response_count_enabled") Boolean responseCountEnabled /** Учитывать ли количество откликов на вакансии из поля counters**/
) {}