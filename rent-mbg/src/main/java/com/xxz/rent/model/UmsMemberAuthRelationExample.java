package com.xxz.rent.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UmsMemberAuthRelationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UmsMemberAuthRelationExample() {
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

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Long value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Long value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Long value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Long value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Long value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Long value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Long> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Long> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Long value1, Long value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Long value1, Long value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andIdentityStatusIsNull() {
            addCriterion("identity_status is null");
            return (Criteria) this;
        }

        public Criteria andIdentityStatusIsNotNull() {
            addCriterion("identity_status is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityStatusEqualTo(Integer value) {
            addCriterion("identity_status =", value, "identityStatus");
            return (Criteria) this;
        }

        public Criteria andIdentityStatusNotEqualTo(Integer value) {
            addCriterion("identity_status <>", value, "identityStatus");
            return (Criteria) this;
        }

        public Criteria andIdentityStatusGreaterThan(Integer value) {
            addCriterion("identity_status >", value, "identityStatus");
            return (Criteria) this;
        }

        public Criteria andIdentityStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("identity_status >=", value, "identityStatus");
            return (Criteria) this;
        }

        public Criteria andIdentityStatusLessThan(Integer value) {
            addCriterion("identity_status <", value, "identityStatus");
            return (Criteria) this;
        }

        public Criteria andIdentityStatusLessThanOrEqualTo(Integer value) {
            addCriterion("identity_status <=", value, "identityStatus");
            return (Criteria) this;
        }

        public Criteria andIdentityStatusIn(List<Integer> values) {
            addCriterion("identity_status in", values, "identityStatus");
            return (Criteria) this;
        }

        public Criteria andIdentityStatusNotIn(List<Integer> values) {
            addCriterion("identity_status not in", values, "identityStatus");
            return (Criteria) this;
        }

        public Criteria andIdentityStatusBetween(Integer value1, Integer value2) {
            addCriterion("identity_status between", value1, value2, "identityStatus");
            return (Criteria) this;
        }

        public Criteria andIdentityStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("identity_status not between", value1, value2, "identityStatus");
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

        public Criteria andKinsfolkStatusIsNull() {
            addCriterion("kinsfolk_status is null");
            return (Criteria) this;
        }

        public Criteria andKinsfolkStatusIsNotNull() {
            addCriterion("kinsfolk_status is not null");
            return (Criteria) this;
        }

        public Criteria andKinsfolkStatusEqualTo(Integer value) {
            addCriterion("kinsfolk_status =", value, "kinsfolkStatus");
            return (Criteria) this;
        }

        public Criteria andKinsfolkStatusNotEqualTo(Integer value) {
            addCriterion("kinsfolk_status <>", value, "kinsfolkStatus");
            return (Criteria) this;
        }

        public Criteria andKinsfolkStatusGreaterThan(Integer value) {
            addCriterion("kinsfolk_status >", value, "kinsfolkStatus");
            return (Criteria) this;
        }

        public Criteria andKinsfolkStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("kinsfolk_status >=", value, "kinsfolkStatus");
            return (Criteria) this;
        }

        public Criteria andKinsfolkStatusLessThan(Integer value) {
            addCriterion("kinsfolk_status <", value, "kinsfolkStatus");
            return (Criteria) this;
        }

        public Criteria andKinsfolkStatusLessThanOrEqualTo(Integer value) {
            addCriterion("kinsfolk_status <=", value, "kinsfolkStatus");
            return (Criteria) this;
        }

        public Criteria andKinsfolkStatusIn(List<Integer> values) {
            addCriterion("kinsfolk_status in", values, "kinsfolkStatus");
            return (Criteria) this;
        }

        public Criteria andKinsfolkStatusNotIn(List<Integer> values) {
            addCriterion("kinsfolk_status not in", values, "kinsfolkStatus");
            return (Criteria) this;
        }

        public Criteria andKinsfolkStatusBetween(Integer value1, Integer value2) {
            addCriterion("kinsfolk_status between", value1, value2, "kinsfolkStatus");
            return (Criteria) this;
        }

        public Criteria andKinsfolkStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("kinsfolk_status not between", value1, value2, "kinsfolkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusIsNull() {
            addCriterion("link_status is null");
            return (Criteria) this;
        }

        public Criteria andLinkStatusIsNotNull() {
            addCriterion("link_status is not null");
            return (Criteria) this;
        }

        public Criteria andLinkStatusEqualTo(Integer value) {
            addCriterion("link_status =", value, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusNotEqualTo(Integer value) {
            addCriterion("link_status <>", value, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusGreaterThan(Integer value) {
            addCriterion("link_status >", value, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("link_status >=", value, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusLessThan(Integer value) {
            addCriterion("link_status <", value, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusLessThanOrEqualTo(Integer value) {
            addCriterion("link_status <=", value, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusIn(List<Integer> values) {
            addCriterion("link_status in", values, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusNotIn(List<Integer> values) {
            addCriterion("link_status not in", values, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusBetween(Integer value1, Integer value2) {
            addCriterion("link_status between", value1, value2, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andLinkStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("link_status not between", value1, value2, "linkStatus");
            return (Criteria) this;
        }

        public Criteria andMobileStatusIsNull() {
            addCriterion("mobile_status is null");
            return (Criteria) this;
        }

        public Criteria andMobileStatusIsNotNull() {
            addCriterion("mobile_status is not null");
            return (Criteria) this;
        }

        public Criteria andMobileStatusEqualTo(Integer value) {
            addCriterion("mobile_status =", value, "mobileStatus");
            return (Criteria) this;
        }

        public Criteria andMobileStatusNotEqualTo(Integer value) {
            addCriterion("mobile_status <>", value, "mobileStatus");
            return (Criteria) this;
        }

        public Criteria andMobileStatusGreaterThan(Integer value) {
            addCriterion("mobile_status >", value, "mobileStatus");
            return (Criteria) this;
        }

        public Criteria andMobileStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("mobile_status >=", value, "mobileStatus");
            return (Criteria) this;
        }

        public Criteria andMobileStatusLessThan(Integer value) {
            addCriterion("mobile_status <", value, "mobileStatus");
            return (Criteria) this;
        }

        public Criteria andMobileStatusLessThanOrEqualTo(Integer value) {
            addCriterion("mobile_status <=", value, "mobileStatus");
            return (Criteria) this;
        }

        public Criteria andMobileStatusIn(List<Integer> values) {
            addCriterion("mobile_status in", values, "mobileStatus");
            return (Criteria) this;
        }

        public Criteria andMobileStatusNotIn(List<Integer> values) {
            addCriterion("mobile_status not in", values, "mobileStatus");
            return (Criteria) this;
        }

        public Criteria andMobileStatusBetween(Integer value1, Integer value2) {
            addCriterion("mobile_status between", value1, value2, "mobileStatus");
            return (Criteria) this;
        }

        public Criteria andMobileStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("mobile_status not between", value1, value2, "mobileStatus");
            return (Criteria) this;
        }

        public Criteria andTaobaoStatusIsNull() {
            addCriterion("taobao_status is null");
            return (Criteria) this;
        }

        public Criteria andTaobaoStatusIsNotNull() {
            addCriterion("taobao_status is not null");
            return (Criteria) this;
        }

        public Criteria andTaobaoStatusEqualTo(Integer value) {
            addCriterion("taobao_status =", value, "taobaoStatus");
            return (Criteria) this;
        }

        public Criteria andTaobaoStatusNotEqualTo(Integer value) {
            addCriterion("taobao_status <>", value, "taobaoStatus");
            return (Criteria) this;
        }

        public Criteria andTaobaoStatusGreaterThan(Integer value) {
            addCriterion("taobao_status >", value, "taobaoStatus");
            return (Criteria) this;
        }

        public Criteria andTaobaoStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("taobao_status >=", value, "taobaoStatus");
            return (Criteria) this;
        }

        public Criteria andTaobaoStatusLessThan(Integer value) {
            addCriterion("taobao_status <", value, "taobaoStatus");
            return (Criteria) this;
        }

        public Criteria andTaobaoStatusLessThanOrEqualTo(Integer value) {
            addCriterion("taobao_status <=", value, "taobaoStatus");
            return (Criteria) this;
        }

        public Criteria andTaobaoStatusIn(List<Integer> values) {
            addCriterion("taobao_status in", values, "taobaoStatus");
            return (Criteria) this;
        }

        public Criteria andTaobaoStatusNotIn(List<Integer> values) {
            addCriterion("taobao_status not in", values, "taobaoStatus");
            return (Criteria) this;
        }

        public Criteria andTaobaoStatusBetween(Integer value1, Integer value2) {
            addCriterion("taobao_status between", value1, value2, "taobaoStatus");
            return (Criteria) this;
        }

        public Criteria andTaobaoStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("taobao_status not between", value1, value2, "taobaoStatus");
            return (Criteria) this;
        }

        public Criteria andStudyStatusIsNull() {
            addCriterion("study_status is null");
            return (Criteria) this;
        }

        public Criteria andStudyStatusIsNotNull() {
            addCriterion("study_status is not null");
            return (Criteria) this;
        }

        public Criteria andStudyStatusEqualTo(Integer value) {
            addCriterion("study_status =", value, "studyStatus");
            return (Criteria) this;
        }

        public Criteria andStudyStatusNotEqualTo(Integer value) {
            addCriterion("study_status <>", value, "studyStatus");
            return (Criteria) this;
        }

        public Criteria andStudyStatusGreaterThan(Integer value) {
            addCriterion("study_status >", value, "studyStatus");
            return (Criteria) this;
        }

        public Criteria andStudyStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("study_status >=", value, "studyStatus");
            return (Criteria) this;
        }

        public Criteria andStudyStatusLessThan(Integer value) {
            addCriterion("study_status <", value, "studyStatus");
            return (Criteria) this;
        }

        public Criteria andStudyStatusLessThanOrEqualTo(Integer value) {
            addCriterion("study_status <=", value, "studyStatus");
            return (Criteria) this;
        }

        public Criteria andStudyStatusIn(List<Integer> values) {
            addCriterion("study_status in", values, "studyStatus");
            return (Criteria) this;
        }

        public Criteria andStudyStatusNotIn(List<Integer> values) {
            addCriterion("study_status not in", values, "studyStatus");
            return (Criteria) this;
        }

        public Criteria andStudyStatusBetween(Integer value1, Integer value2) {
            addCriterion("study_status between", value1, value2, "studyStatus");
            return (Criteria) this;
        }

        public Criteria andStudyStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("study_status not between", value1, value2, "studyStatus");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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