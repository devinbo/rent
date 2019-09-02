package com.xxz.rent.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UmsMemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UmsMemberExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andIconIsNull() {
            addCriterion("icon is null");
            return (Criteria) this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("icon is not null");
            return (Criteria) this;
        }

        public Criteria andIconEqualTo(String value) {
            addCriterion("icon =", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotEqualTo(String value) {
            addCriterion("icon <>", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("icon >", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("icon >=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThan(String value) {
            addCriterion("icon <", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("icon <=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLike(String value) {
            addCriterion("icon like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotLike(String value) {
            addCriterion("icon not like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconIn(List<String> values) {
            addCriterion("icon in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotIn(List<String> values) {
            addCriterion("icon not in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("icon between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("icon not between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Integer value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Integer value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Integer value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Integer value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Integer value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Integer> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Integer> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Integer value1, Integer value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andJobIsNull() {
            addCriterion("job is null");
            return (Criteria) this;
        }

        public Criteria andJobIsNotNull() {
            addCriterion("job is not null");
            return (Criteria) this;
        }

        public Criteria andJobEqualTo(String value) {
            addCriterion("job =", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotEqualTo(String value) {
            addCriterion("job <>", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThan(String value) {
            addCriterion("job >", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThanOrEqualTo(String value) {
            addCriterion("job >=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThan(String value) {
            addCriterion("job <", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThanOrEqualTo(String value) {
            addCriterion("job <=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLike(String value) {
            addCriterion("job like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotLike(String value) {
            addCriterion("job not like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobIn(List<String> values) {
            addCriterion("job in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotIn(List<String> values) {
            addCriterion("job not in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobBetween(String value1, String value2) {
            addCriterion("job between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotBetween(String value1, String value2) {
            addCriterion("job not between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andPersonalizedSignatureIsNull() {
            addCriterion("personalized_signature is null");
            return (Criteria) this;
        }

        public Criteria andPersonalizedSignatureIsNotNull() {
            addCriterion("personalized_signature is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalizedSignatureEqualTo(String value) {
            addCriterion("personalized_signature =", value, "personalizedSignature");
            return (Criteria) this;
        }

        public Criteria andPersonalizedSignatureNotEqualTo(String value) {
            addCriterion("personalized_signature <>", value, "personalizedSignature");
            return (Criteria) this;
        }

        public Criteria andPersonalizedSignatureGreaterThan(String value) {
            addCriterion("personalized_signature >", value, "personalizedSignature");
            return (Criteria) this;
        }

        public Criteria andPersonalizedSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("personalized_signature >=", value, "personalizedSignature");
            return (Criteria) this;
        }

        public Criteria andPersonalizedSignatureLessThan(String value) {
            addCriterion("personalized_signature <", value, "personalizedSignature");
            return (Criteria) this;
        }

        public Criteria andPersonalizedSignatureLessThanOrEqualTo(String value) {
            addCriterion("personalized_signature <=", value, "personalizedSignature");
            return (Criteria) this;
        }

        public Criteria andPersonalizedSignatureLike(String value) {
            addCriterion("personalized_signature like", value, "personalizedSignature");
            return (Criteria) this;
        }

        public Criteria andPersonalizedSignatureNotLike(String value) {
            addCriterion("personalized_signature not like", value, "personalizedSignature");
            return (Criteria) this;
        }

        public Criteria andPersonalizedSignatureIn(List<String> values) {
            addCriterion("personalized_signature in", values, "personalizedSignature");
            return (Criteria) this;
        }

        public Criteria andPersonalizedSignatureNotIn(List<String> values) {
            addCriterion("personalized_signature not in", values, "personalizedSignature");
            return (Criteria) this;
        }

        public Criteria andPersonalizedSignatureBetween(String value1, String value2) {
            addCriterion("personalized_signature between", value1, value2, "personalizedSignature");
            return (Criteria) this;
        }

        public Criteria andPersonalizedSignatureNotBetween(String value1, String value2) {
            addCriterion("personalized_signature not between", value1, value2, "personalizedSignature");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIsNull() {
            addCriterion("source_type is null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIsNotNull() {
            addCriterion("source_type is not null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeEqualTo(Integer value) {
            addCriterion("source_type =", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotEqualTo(Integer value) {
            addCriterion("source_type <>", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeGreaterThan(Integer value) {
            addCriterion("source_type >", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("source_type >=", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLessThan(Integer value) {
            addCriterion("source_type <", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("source_type <=", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIn(List<Integer> values) {
            addCriterion("source_type in", values, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotIn(List<Integer> values) {
            addCriterion("source_type not in", values, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeBetween(Integer value1, Integer value2) {
            addCriterion("source_type between", value1, value2, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("source_type not between", value1, value2, "sourceType");
            return (Criteria) this;
        }

        public Criteria andIntegrationIsNull() {
            addCriterion("integration is null");
            return (Criteria) this;
        }

        public Criteria andIntegrationIsNotNull() {
            addCriterion("integration is not null");
            return (Criteria) this;
        }

        public Criteria andIntegrationEqualTo(Integer value) {
            addCriterion("integration =", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationNotEqualTo(Integer value) {
            addCriterion("integration <>", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationGreaterThan(Integer value) {
            addCriterion("integration >", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationGreaterThanOrEqualTo(Integer value) {
            addCriterion("integration >=", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationLessThan(Integer value) {
            addCriterion("integration <", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationLessThanOrEqualTo(Integer value) {
            addCriterion("integration <=", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationIn(List<Integer> values) {
            addCriterion("integration in", values, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationNotIn(List<Integer> values) {
            addCriterion("integration not in", values, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationBetween(Integer value1, Integer value2) {
            addCriterion("integration between", value1, value2, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationNotBetween(Integer value1, Integer value2) {
            addCriterion("integration not between", value1, value2, "integration");
            return (Criteria) this;
        }

        public Criteria andGrowthIsNull() {
            addCriterion("growth is null");
            return (Criteria) this;
        }

        public Criteria andGrowthIsNotNull() {
            addCriterion("growth is not null");
            return (Criteria) this;
        }

        public Criteria andGrowthEqualTo(Integer value) {
            addCriterion("growth =", value, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthNotEqualTo(Integer value) {
            addCriterion("growth <>", value, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthGreaterThan(Integer value) {
            addCriterion("growth >", value, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthGreaterThanOrEqualTo(Integer value) {
            addCriterion("growth >=", value, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthLessThan(Integer value) {
            addCriterion("growth <", value, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthLessThanOrEqualTo(Integer value) {
            addCriterion("growth <=", value, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthIn(List<Integer> values) {
            addCriterion("growth in", values, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthNotIn(List<Integer> values) {
            addCriterion("growth not in", values, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthBetween(Integer value1, Integer value2) {
            addCriterion("growth between", value1, value2, "growth");
            return (Criteria) this;
        }

        public Criteria andGrowthNotBetween(Integer value1, Integer value2) {
            addCriterion("growth not between", value1, value2, "growth");
            return (Criteria) this;
        }

        public Criteria andHistoryIntegrationIsNull() {
            addCriterion("history_integration is null");
            return (Criteria) this;
        }

        public Criteria andHistoryIntegrationIsNotNull() {
            addCriterion("history_integration is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryIntegrationEqualTo(Integer value) {
            addCriterion("history_integration =", value, "historyIntegration");
            return (Criteria) this;
        }

        public Criteria andHistoryIntegrationNotEqualTo(Integer value) {
            addCriterion("history_integration <>", value, "historyIntegration");
            return (Criteria) this;
        }

        public Criteria andHistoryIntegrationGreaterThan(Integer value) {
            addCriterion("history_integration >", value, "historyIntegration");
            return (Criteria) this;
        }

        public Criteria andHistoryIntegrationGreaterThanOrEqualTo(Integer value) {
            addCriterion("history_integration >=", value, "historyIntegration");
            return (Criteria) this;
        }

        public Criteria andHistoryIntegrationLessThan(Integer value) {
            addCriterion("history_integration <", value, "historyIntegration");
            return (Criteria) this;
        }

        public Criteria andHistoryIntegrationLessThanOrEqualTo(Integer value) {
            addCriterion("history_integration <=", value, "historyIntegration");
            return (Criteria) this;
        }

        public Criteria andHistoryIntegrationIn(List<Integer> values) {
            addCriterion("history_integration in", values, "historyIntegration");
            return (Criteria) this;
        }

        public Criteria andHistoryIntegrationNotIn(List<Integer> values) {
            addCriterion("history_integration not in", values, "historyIntegration");
            return (Criteria) this;
        }

        public Criteria andHistoryIntegrationBetween(Integer value1, Integer value2) {
            addCriterion("history_integration between", value1, value2, "historyIntegration");
            return (Criteria) this;
        }

        public Criteria andHistoryIntegrationNotBetween(Integer value1, Integer value2) {
            addCriterion("history_integration not between", value1, value2, "historyIntegration");
            return (Criteria) this;
        }

        public Criteria andOrderCountIsNull() {
            addCriterion("order_count is null");
            return (Criteria) this;
        }

        public Criteria andOrderCountIsNotNull() {
            addCriterion("order_count is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCountEqualTo(Integer value) {
            addCriterion("order_count =", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountNotEqualTo(Integer value) {
            addCriterion("order_count <>", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountGreaterThan(Integer value) {
            addCriterion("order_count >", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_count >=", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountLessThan(Integer value) {
            addCriterion("order_count <", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountLessThanOrEqualTo(Integer value) {
            addCriterion("order_count <=", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountIn(List<Integer> values) {
            addCriterion("order_count in", values, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountNotIn(List<Integer> values) {
            addCriterion("order_count not in", values, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountBetween(Integer value1, Integer value2) {
            addCriterion("order_count between", value1, value2, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_count not between", value1, value2, "orderCount");
            return (Criteria) this;
        }

        public Criteria andRentCountIsNull() {
            addCriterion("rent_count is null");
            return (Criteria) this;
        }

        public Criteria andRentCountIsNotNull() {
            addCriterion("rent_count is not null");
            return (Criteria) this;
        }

        public Criteria andRentCountEqualTo(Integer value) {
            addCriterion("rent_count =", value, "rentCount");
            return (Criteria) this;
        }

        public Criteria andRentCountNotEqualTo(Integer value) {
            addCriterion("rent_count <>", value, "rentCount");
            return (Criteria) this;
        }

        public Criteria andRentCountGreaterThan(Integer value) {
            addCriterion("rent_count >", value, "rentCount");
            return (Criteria) this;
        }

        public Criteria andRentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("rent_count >=", value, "rentCount");
            return (Criteria) this;
        }

        public Criteria andRentCountLessThan(Integer value) {
            addCriterion("rent_count <", value, "rentCount");
            return (Criteria) this;
        }

        public Criteria andRentCountLessThanOrEqualTo(Integer value) {
            addCriterion("rent_count <=", value, "rentCount");
            return (Criteria) this;
        }

        public Criteria andRentCountIn(List<Integer> values) {
            addCriterion("rent_count in", values, "rentCount");
            return (Criteria) this;
        }

        public Criteria andRentCountNotIn(List<Integer> values) {
            addCriterion("rent_count not in", values, "rentCount");
            return (Criteria) this;
        }

        public Criteria andRentCountBetween(Integer value1, Integer value2) {
            addCriterion("rent_count between", value1, value2, "rentCount");
            return (Criteria) this;
        }

        public Criteria andRentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("rent_count not between", value1, value2, "rentCount");
            return (Criteria) this;
        }

        public Criteria andHireCountIsNull() {
            addCriterion("hire_count is null");
            return (Criteria) this;
        }

        public Criteria andHireCountIsNotNull() {
            addCriterion("hire_count is not null");
            return (Criteria) this;
        }

        public Criteria andHireCountEqualTo(Integer value) {
            addCriterion("hire_count =", value, "hireCount");
            return (Criteria) this;
        }

        public Criteria andHireCountNotEqualTo(Integer value) {
            addCriterion("hire_count <>", value, "hireCount");
            return (Criteria) this;
        }

        public Criteria andHireCountGreaterThan(Integer value) {
            addCriterion("hire_count >", value, "hireCount");
            return (Criteria) this;
        }

        public Criteria andHireCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("hire_count >=", value, "hireCount");
            return (Criteria) this;
        }

        public Criteria andHireCountLessThan(Integer value) {
            addCriterion("hire_count <", value, "hireCount");
            return (Criteria) this;
        }

        public Criteria andHireCountLessThanOrEqualTo(Integer value) {
            addCriterion("hire_count <=", value, "hireCount");
            return (Criteria) this;
        }

        public Criteria andHireCountIn(List<Integer> values) {
            addCriterion("hire_count in", values, "hireCount");
            return (Criteria) this;
        }

        public Criteria andHireCountNotIn(List<Integer> values) {
            addCriterion("hire_count not in", values, "hireCount");
            return (Criteria) this;
        }

        public Criteria andHireCountBetween(Integer value1, Integer value2) {
            addCriterion("hire_count between", value1, value2, "hireCount");
            return (Criteria) this;
        }

        public Criteria andHireCountNotBetween(Integer value1, Integer value2) {
            addCriterion("hire_count not between", value1, value2, "hireCount");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusIsNull() {
            addCriterion("complete_status is null");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusIsNotNull() {
            addCriterion("complete_status is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusEqualTo(Integer value) {
            addCriterion("complete_status =", value, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusNotEqualTo(Integer value) {
            addCriterion("complete_status <>", value, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusGreaterThan(Integer value) {
            addCriterion("complete_status >", value, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("complete_status >=", value, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusLessThan(Integer value) {
            addCriterion("complete_status <", value, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusLessThanOrEqualTo(Integer value) {
            addCriterion("complete_status <=", value, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusIn(List<Integer> values) {
            addCriterion("complete_status in", values, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusNotIn(List<Integer> values) {
            addCriterion("complete_status not in", values, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusBetween(Integer value1, Integer value2) {
            addCriterion("complete_status between", value1, value2, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("complete_status not between", value1, value2, "completeStatus");
            return (Criteria) this;
        }

        public Criteria andBaseinfoStatusIsNull() {
            addCriterion("baseinfo_status is null");
            return (Criteria) this;
        }

        public Criteria andBaseinfoStatusIsNotNull() {
            addCriterion("baseinfo_status is not null");
            return (Criteria) this;
        }

        public Criteria andBaseinfoStatusEqualTo(Integer value) {
            addCriterion("baseinfo_status =", value, "baseinfoStatus");
            return (Criteria) this;
        }

        public Criteria andBaseinfoStatusNotEqualTo(Integer value) {
            addCriterion("baseinfo_status <>", value, "baseinfoStatus");
            return (Criteria) this;
        }

        public Criteria andBaseinfoStatusGreaterThan(Integer value) {
            addCriterion("baseinfo_status >", value, "baseinfoStatus");
            return (Criteria) this;
        }

        public Criteria andBaseinfoStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("baseinfo_status >=", value, "baseinfoStatus");
            return (Criteria) this;
        }

        public Criteria andBaseinfoStatusLessThan(Integer value) {
            addCriterion("baseinfo_status <", value, "baseinfoStatus");
            return (Criteria) this;
        }

        public Criteria andBaseinfoStatusLessThanOrEqualTo(Integer value) {
            addCriterion("baseinfo_status <=", value, "baseinfoStatus");
            return (Criteria) this;
        }

        public Criteria andBaseinfoStatusIn(List<Integer> values) {
            addCriterion("baseinfo_status in", values, "baseinfoStatus");
            return (Criteria) this;
        }

        public Criteria andBaseinfoStatusNotIn(List<Integer> values) {
            addCriterion("baseinfo_status not in", values, "baseinfoStatus");
            return (Criteria) this;
        }

        public Criteria andBaseinfoStatusBetween(Integer value1, Integer value2) {
            addCriterion("baseinfo_status between", value1, value2, "baseinfoStatus");
            return (Criteria) this;
        }

        public Criteria andBaseinfoStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("baseinfo_status not between", value1, value2, "baseinfoStatus");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidIsNull() {
            addCriterion("wechat_openid is null");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidIsNotNull() {
            addCriterion("wechat_openid is not null");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidEqualTo(String value) {
            addCriterion("wechat_openid =", value, "wechatOpenid");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidNotEqualTo(String value) {
            addCriterion("wechat_openid <>", value, "wechatOpenid");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidGreaterThan(String value) {
            addCriterion("wechat_openid >", value, "wechatOpenid");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_openid >=", value, "wechatOpenid");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidLessThan(String value) {
            addCriterion("wechat_openid <", value, "wechatOpenid");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidLessThanOrEqualTo(String value) {
            addCriterion("wechat_openid <=", value, "wechatOpenid");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidLike(String value) {
            addCriterion("wechat_openid like", value, "wechatOpenid");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidNotLike(String value) {
            addCriterion("wechat_openid not like", value, "wechatOpenid");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidIn(List<String> values) {
            addCriterion("wechat_openid in", values, "wechatOpenid");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidNotIn(List<String> values) {
            addCriterion("wechat_openid not in", values, "wechatOpenid");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidBetween(String value1, String value2) {
            addCriterion("wechat_openid between", value1, value2, "wechatOpenid");
            return (Criteria) this;
        }

        public Criteria andWechatOpenidNotBetween(String value1, String value2) {
            addCriterion("wechat_openid not between", value1, value2, "wechatOpenid");
            return (Criteria) this;
        }

        public Criteria andWechatNickIsNull() {
            addCriterion("wechat_nick is null");
            return (Criteria) this;
        }

        public Criteria andWechatNickIsNotNull() {
            addCriterion("wechat_nick is not null");
            return (Criteria) this;
        }

        public Criteria andWechatNickEqualTo(String value) {
            addCriterion("wechat_nick =", value, "wechatNick");
            return (Criteria) this;
        }

        public Criteria andWechatNickNotEqualTo(String value) {
            addCriterion("wechat_nick <>", value, "wechatNick");
            return (Criteria) this;
        }

        public Criteria andWechatNickGreaterThan(String value) {
            addCriterion("wechat_nick >", value, "wechatNick");
            return (Criteria) this;
        }

        public Criteria andWechatNickGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_nick >=", value, "wechatNick");
            return (Criteria) this;
        }

        public Criteria andWechatNickLessThan(String value) {
            addCriterion("wechat_nick <", value, "wechatNick");
            return (Criteria) this;
        }

        public Criteria andWechatNickLessThanOrEqualTo(String value) {
            addCriterion("wechat_nick <=", value, "wechatNick");
            return (Criteria) this;
        }

        public Criteria andWechatNickLike(String value) {
            addCriterion("wechat_nick like", value, "wechatNick");
            return (Criteria) this;
        }

        public Criteria andWechatNickNotLike(String value) {
            addCriterion("wechat_nick not like", value, "wechatNick");
            return (Criteria) this;
        }

        public Criteria andWechatNickIn(List<String> values) {
            addCriterion("wechat_nick in", values, "wechatNick");
            return (Criteria) this;
        }

        public Criteria andWechatNickNotIn(List<String> values) {
            addCriterion("wechat_nick not in", values, "wechatNick");
            return (Criteria) this;
        }

        public Criteria andWechatNickBetween(String value1, String value2) {
            addCriterion("wechat_nick between", value1, value2, "wechatNick");
            return (Criteria) this;
        }

        public Criteria andWechatNickNotBetween(String value1, String value2) {
            addCriterion("wechat_nick not between", value1, value2, "wechatNick");
            return (Criteria) this;
        }

        public Criteria andWechatHeadPicIsNull() {
            addCriterion("wechat_head_pic is null");
            return (Criteria) this;
        }

        public Criteria andWechatHeadPicIsNotNull() {
            addCriterion("wechat_head_pic is not null");
            return (Criteria) this;
        }

        public Criteria andWechatHeadPicEqualTo(String value) {
            addCriterion("wechat_head_pic =", value, "wechatHeadPic");
            return (Criteria) this;
        }

        public Criteria andWechatHeadPicNotEqualTo(String value) {
            addCriterion("wechat_head_pic <>", value, "wechatHeadPic");
            return (Criteria) this;
        }

        public Criteria andWechatHeadPicGreaterThan(String value) {
            addCriterion("wechat_head_pic >", value, "wechatHeadPic");
            return (Criteria) this;
        }

        public Criteria andWechatHeadPicGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_head_pic >=", value, "wechatHeadPic");
            return (Criteria) this;
        }

        public Criteria andWechatHeadPicLessThan(String value) {
            addCriterion("wechat_head_pic <", value, "wechatHeadPic");
            return (Criteria) this;
        }

        public Criteria andWechatHeadPicLessThanOrEqualTo(String value) {
            addCriterion("wechat_head_pic <=", value, "wechatHeadPic");
            return (Criteria) this;
        }

        public Criteria andWechatHeadPicLike(String value) {
            addCriterion("wechat_head_pic like", value, "wechatHeadPic");
            return (Criteria) this;
        }

        public Criteria andWechatHeadPicNotLike(String value) {
            addCriterion("wechat_head_pic not like", value, "wechatHeadPic");
            return (Criteria) this;
        }

        public Criteria andWechatHeadPicIn(List<String> values) {
            addCriterion("wechat_head_pic in", values, "wechatHeadPic");
            return (Criteria) this;
        }

        public Criteria andWechatHeadPicNotIn(List<String> values) {
            addCriterion("wechat_head_pic not in", values, "wechatHeadPic");
            return (Criteria) this;
        }

        public Criteria andWechatHeadPicBetween(String value1, String value2) {
            addCriterion("wechat_head_pic between", value1, value2, "wechatHeadPic");
            return (Criteria) this;
        }

        public Criteria andWechatHeadPicNotBetween(String value1, String value2) {
            addCriterion("wechat_head_pic not between", value1, value2, "wechatHeadPic");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andFreeMoneyIsNull() {
            addCriterion("free_money is null");
            return (Criteria) this;
        }

        public Criteria andFreeMoneyIsNotNull() {
            addCriterion("free_money is not null");
            return (Criteria) this;
        }

        public Criteria andFreeMoneyEqualTo(BigDecimal value) {
            addCriterion("free_money =", value, "freeMoney");
            return (Criteria) this;
        }

        public Criteria andFreeMoneyNotEqualTo(BigDecimal value) {
            addCriterion("free_money <>", value, "freeMoney");
            return (Criteria) this;
        }

        public Criteria andFreeMoneyGreaterThan(BigDecimal value) {
            addCriterion("free_money >", value, "freeMoney");
            return (Criteria) this;
        }

        public Criteria andFreeMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("free_money >=", value, "freeMoney");
            return (Criteria) this;
        }

        public Criteria andFreeMoneyLessThan(BigDecimal value) {
            addCriterion("free_money <", value, "freeMoney");
            return (Criteria) this;
        }

        public Criteria andFreeMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("free_money <=", value, "freeMoney");
            return (Criteria) this;
        }

        public Criteria andFreeMoneyIn(List<BigDecimal> values) {
            addCriterion("free_money in", values, "freeMoney");
            return (Criteria) this;
        }

        public Criteria andFreeMoneyNotIn(List<BigDecimal> values) {
            addCriterion("free_money not in", values, "freeMoney");
            return (Criteria) this;
        }

        public Criteria andFreeMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("free_money between", value1, value2, "freeMoney");
            return (Criteria) this;
        }

        public Criteria andFreeMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("free_money not between", value1, value2, "freeMoney");
            return (Criteria) this;
        }

        public Criteria andWechatProvinceIsNull() {
            addCriterion("wechat_province is null");
            return (Criteria) this;
        }

        public Criteria andWechatProvinceIsNotNull() {
            addCriterion("wechat_province is not null");
            return (Criteria) this;
        }

        public Criteria andWechatProvinceEqualTo(String value) {
            addCriterion("wechat_province =", value, "wechatProvince");
            return (Criteria) this;
        }

        public Criteria andWechatProvinceNotEqualTo(String value) {
            addCriterion("wechat_province <>", value, "wechatProvince");
            return (Criteria) this;
        }

        public Criteria andWechatProvinceGreaterThan(String value) {
            addCriterion("wechat_province >", value, "wechatProvince");
            return (Criteria) this;
        }

        public Criteria andWechatProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_province >=", value, "wechatProvince");
            return (Criteria) this;
        }

        public Criteria andWechatProvinceLessThan(String value) {
            addCriterion("wechat_province <", value, "wechatProvince");
            return (Criteria) this;
        }

        public Criteria andWechatProvinceLessThanOrEqualTo(String value) {
            addCriterion("wechat_province <=", value, "wechatProvince");
            return (Criteria) this;
        }

        public Criteria andWechatProvinceLike(String value) {
            addCriterion("wechat_province like", value, "wechatProvince");
            return (Criteria) this;
        }

        public Criteria andWechatProvinceNotLike(String value) {
            addCriterion("wechat_province not like", value, "wechatProvince");
            return (Criteria) this;
        }

        public Criteria andWechatProvinceIn(List<String> values) {
            addCriterion("wechat_province in", values, "wechatProvince");
            return (Criteria) this;
        }

        public Criteria andWechatProvinceNotIn(List<String> values) {
            addCriterion("wechat_province not in", values, "wechatProvince");
            return (Criteria) this;
        }

        public Criteria andWechatProvinceBetween(String value1, String value2) {
            addCriterion("wechat_province between", value1, value2, "wechatProvince");
            return (Criteria) this;
        }

        public Criteria andWechatProvinceNotBetween(String value1, String value2) {
            addCriterion("wechat_province not between", value1, value2, "wechatProvince");
            return (Criteria) this;
        }

        public Criteria andWechatCityIsNull() {
            addCriterion("wechat_city is null");
            return (Criteria) this;
        }

        public Criteria andWechatCityIsNotNull() {
            addCriterion("wechat_city is not null");
            return (Criteria) this;
        }

        public Criteria andWechatCityEqualTo(String value) {
            addCriterion("wechat_city =", value, "wechatCity");
            return (Criteria) this;
        }

        public Criteria andWechatCityNotEqualTo(String value) {
            addCriterion("wechat_city <>", value, "wechatCity");
            return (Criteria) this;
        }

        public Criteria andWechatCityGreaterThan(String value) {
            addCriterion("wechat_city >", value, "wechatCity");
            return (Criteria) this;
        }

        public Criteria andWechatCityGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_city >=", value, "wechatCity");
            return (Criteria) this;
        }

        public Criteria andWechatCityLessThan(String value) {
            addCriterion("wechat_city <", value, "wechatCity");
            return (Criteria) this;
        }

        public Criteria andWechatCityLessThanOrEqualTo(String value) {
            addCriterion("wechat_city <=", value, "wechatCity");
            return (Criteria) this;
        }

        public Criteria andWechatCityLike(String value) {
            addCriterion("wechat_city like", value, "wechatCity");
            return (Criteria) this;
        }

        public Criteria andWechatCityNotLike(String value) {
            addCriterion("wechat_city not like", value, "wechatCity");
            return (Criteria) this;
        }

        public Criteria andWechatCityIn(List<String> values) {
            addCriterion("wechat_city in", values, "wechatCity");
            return (Criteria) this;
        }

        public Criteria andWechatCityNotIn(List<String> values) {
            addCriterion("wechat_city not in", values, "wechatCity");
            return (Criteria) this;
        }

        public Criteria andWechatCityBetween(String value1, String value2) {
            addCriterion("wechat_city between", value1, value2, "wechatCity");
            return (Criteria) this;
        }

        public Criteria andWechatCityNotBetween(String value1, String value2) {
            addCriterion("wechat_city not between", value1, value2, "wechatCity");
            return (Criteria) this;
        }

        public Criteria andWechatCountryIsNull() {
            addCriterion("`wechat_ country` is null");
            return (Criteria) this;
        }

        public Criteria andWechatCountryIsNotNull() {
            addCriterion("`wechat_ country` is not null");
            return (Criteria) this;
        }

        public Criteria andWechatCountryEqualTo(String value) {
            addCriterion("`wechat_ country` =", value, "wechatCountry");
            return (Criteria) this;
        }

        public Criteria andWechatCountryNotEqualTo(String value) {
            addCriterion("`wechat_ country` <>", value, "wechatCountry");
            return (Criteria) this;
        }

        public Criteria andWechatCountryGreaterThan(String value) {
            addCriterion("`wechat_ country` >", value, "wechatCountry");
            return (Criteria) this;
        }

        public Criteria andWechatCountryGreaterThanOrEqualTo(String value) {
            addCriterion("`wechat_ country` >=", value, "wechatCountry");
            return (Criteria) this;
        }

        public Criteria andWechatCountryLessThan(String value) {
            addCriterion("`wechat_ country` <", value, "wechatCountry");
            return (Criteria) this;
        }

        public Criteria andWechatCountryLessThanOrEqualTo(String value) {
            addCriterion("`wechat_ country` <=", value, "wechatCountry");
            return (Criteria) this;
        }

        public Criteria andWechatCountryLike(String value) {
            addCriterion("`wechat_ country` like", value, "wechatCountry");
            return (Criteria) this;
        }

        public Criteria andWechatCountryNotLike(String value) {
            addCriterion("`wechat_ country` not like", value, "wechatCountry");
            return (Criteria) this;
        }

        public Criteria andWechatCountryIn(List<String> values) {
            addCriterion("`wechat_ country` in", values, "wechatCountry");
            return (Criteria) this;
        }

        public Criteria andWechatCountryNotIn(List<String> values) {
            addCriterion("`wechat_ country` not in", values, "wechatCountry");
            return (Criteria) this;
        }

        public Criteria andWechatCountryBetween(String value1, String value2) {
            addCriterion("`wechat_ country` between", value1, value2, "wechatCountry");
            return (Criteria) this;
        }

        public Criteria andWechatCountryNotBetween(String value1, String value2) {
            addCriterion("`wechat_ country` not between", value1, value2, "wechatCountry");
            return (Criteria) this;
        }

        public Criteria andCreditworthinessIsNull() {
            addCriterion("creditworthiness is null");
            return (Criteria) this;
        }

        public Criteria andCreditworthinessIsNotNull() {
            addCriterion("creditworthiness is not null");
            return (Criteria) this;
        }

        public Criteria andCreditworthinessEqualTo(Integer value) {
            addCriterion("creditworthiness =", value, "creditworthiness");
            return (Criteria) this;
        }

        public Criteria andCreditworthinessNotEqualTo(Integer value) {
            addCriterion("creditworthiness <>", value, "creditworthiness");
            return (Criteria) this;
        }

        public Criteria andCreditworthinessGreaterThan(Integer value) {
            addCriterion("creditworthiness >", value, "creditworthiness");
            return (Criteria) this;
        }

        public Criteria andCreditworthinessGreaterThanOrEqualTo(Integer value) {
            addCriterion("creditworthiness >=", value, "creditworthiness");
            return (Criteria) this;
        }

        public Criteria andCreditworthinessLessThan(Integer value) {
            addCriterion("creditworthiness <", value, "creditworthiness");
            return (Criteria) this;
        }

        public Criteria andCreditworthinessLessThanOrEqualTo(Integer value) {
            addCriterion("creditworthiness <=", value, "creditworthiness");
            return (Criteria) this;
        }

        public Criteria andCreditworthinessIn(List<Integer> values) {
            addCriterion("creditworthiness in", values, "creditworthiness");
            return (Criteria) this;
        }

        public Criteria andCreditworthinessNotIn(List<Integer> values) {
            addCriterion("creditworthiness not in", values, "creditworthiness");
            return (Criteria) this;
        }

        public Criteria andCreditworthinessBetween(Integer value1, Integer value2) {
            addCriterion("creditworthiness between", value1, value2, "creditworthiness");
            return (Criteria) this;
        }

        public Criteria andCreditworthinessNotBetween(Integer value1, Integer value2) {
            addCriterion("creditworthiness not between", value1, value2, "creditworthiness");
            return (Criteria) this;
        }

        public Criteria andAlipayNoIsNull() {
            addCriterion("alipay_no is null");
            return (Criteria) this;
        }

        public Criteria andAlipayNoIsNotNull() {
            addCriterion("alipay_no is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayNoEqualTo(String value) {
            addCriterion("alipay_no =", value, "alipayNo");
            return (Criteria) this;
        }

        public Criteria andAlipayNoNotEqualTo(String value) {
            addCriterion("alipay_no <>", value, "alipayNo");
            return (Criteria) this;
        }

        public Criteria andAlipayNoGreaterThan(String value) {
            addCriterion("alipay_no >", value, "alipayNo");
            return (Criteria) this;
        }

        public Criteria andAlipayNoGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_no >=", value, "alipayNo");
            return (Criteria) this;
        }

        public Criteria andAlipayNoLessThan(String value) {
            addCriterion("alipay_no <", value, "alipayNo");
            return (Criteria) this;
        }

        public Criteria andAlipayNoLessThanOrEqualTo(String value) {
            addCriterion("alipay_no <=", value, "alipayNo");
            return (Criteria) this;
        }

        public Criteria andAlipayNoLike(String value) {
            addCriterion("alipay_no like", value, "alipayNo");
            return (Criteria) this;
        }

        public Criteria andAlipayNoNotLike(String value) {
            addCriterion("alipay_no not like", value, "alipayNo");
            return (Criteria) this;
        }

        public Criteria andAlipayNoIn(List<String> values) {
            addCriterion("alipay_no in", values, "alipayNo");
            return (Criteria) this;
        }

        public Criteria andAlipayNoNotIn(List<String> values) {
            addCriterion("alipay_no not in", values, "alipayNo");
            return (Criteria) this;
        }

        public Criteria andAlipayNoBetween(String value1, String value2) {
            addCriterion("alipay_no between", value1, value2, "alipayNo");
            return (Criteria) this;
        }

        public Criteria andAlipayNoNotBetween(String value1, String value2) {
            addCriterion("alipay_no not between", value1, value2, "alipayNo");
            return (Criteria) this;
        }

        public Criteria andWechatNoIsNull() {
            addCriterion("wechat_no is null");
            return (Criteria) this;
        }

        public Criteria andWechatNoIsNotNull() {
            addCriterion("wechat_no is not null");
            return (Criteria) this;
        }

        public Criteria andWechatNoEqualTo(String value) {
            addCriterion("wechat_no =", value, "wechatNo");
            return (Criteria) this;
        }

        public Criteria andWechatNoNotEqualTo(String value) {
            addCriterion("wechat_no <>", value, "wechatNo");
            return (Criteria) this;
        }

        public Criteria andWechatNoGreaterThan(String value) {
            addCriterion("wechat_no >", value, "wechatNo");
            return (Criteria) this;
        }

        public Criteria andWechatNoGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_no >=", value, "wechatNo");
            return (Criteria) this;
        }

        public Criteria andWechatNoLessThan(String value) {
            addCriterion("wechat_no <", value, "wechatNo");
            return (Criteria) this;
        }

        public Criteria andWechatNoLessThanOrEqualTo(String value) {
            addCriterion("wechat_no <=", value, "wechatNo");
            return (Criteria) this;
        }

        public Criteria andWechatNoLike(String value) {
            addCriterion("wechat_no like", value, "wechatNo");
            return (Criteria) this;
        }

        public Criteria andWechatNoNotLike(String value) {
            addCriterion("wechat_no not like", value, "wechatNo");
            return (Criteria) this;
        }

        public Criteria andWechatNoIn(List<String> values) {
            addCriterion("wechat_no in", values, "wechatNo");
            return (Criteria) this;
        }

        public Criteria andWechatNoNotIn(List<String> values) {
            addCriterion("wechat_no not in", values, "wechatNo");
            return (Criteria) this;
        }

        public Criteria andWechatNoBetween(String value1, String value2) {
            addCriterion("wechat_no between", value1, value2, "wechatNo");
            return (Criteria) this;
        }

        public Criteria andWechatNoNotBetween(String value1, String value2) {
            addCriterion("wechat_no not between", value1, value2, "wechatNo");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}