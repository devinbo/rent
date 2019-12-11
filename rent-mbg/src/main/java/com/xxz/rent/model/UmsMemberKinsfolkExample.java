package com.xxz.rent.model;

import java.util.ArrayList;
import java.util.List;

public class UmsMemberKinsfolkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UmsMemberKinsfolkExample() {
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

        public Criteria andName1IsNull() {
            addCriterion("name1 is null");
            return (Criteria) this;
        }

        public Criteria andName1IsNotNull() {
            addCriterion("name1 is not null");
            return (Criteria) this;
        }

        public Criteria andName1EqualTo(String value) {
            addCriterion("name1 =", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1NotEqualTo(String value) {
            addCriterion("name1 <>", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1GreaterThan(String value) {
            addCriterion("name1 >", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1GreaterThanOrEqualTo(String value) {
            addCriterion("name1 >=", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1LessThan(String value) {
            addCriterion("name1 <", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1LessThanOrEqualTo(String value) {
            addCriterion("name1 <=", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1Like(String value) {
            addCriterion("name1 like", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1NotLike(String value) {
            addCriterion("name1 not like", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1In(List<String> values) {
            addCriterion("name1 in", values, "name1");
            return (Criteria) this;
        }

        public Criteria andName1NotIn(List<String> values) {
            addCriterion("name1 not in", values, "name1");
            return (Criteria) this;
        }

        public Criteria andName1Between(String value1, String value2) {
            addCriterion("name1 between", value1, value2, "name1");
            return (Criteria) this;
        }

        public Criteria andName1NotBetween(String value1, String value2) {
            addCriterion("name1 not between", value1, value2, "name1");
            return (Criteria) this;
        }

        public Criteria andSex1IsNull() {
            addCriterion("sex1 is null");
            return (Criteria) this;
        }

        public Criteria andSex1IsNotNull() {
            addCriterion("sex1 is not null");
            return (Criteria) this;
        }

        public Criteria andSex1EqualTo(Integer value) {
            addCriterion("sex1 =", value, "sex1");
            return (Criteria) this;
        }

        public Criteria andSex1NotEqualTo(Integer value) {
            addCriterion("sex1 <>", value, "sex1");
            return (Criteria) this;
        }

        public Criteria andSex1GreaterThan(Integer value) {
            addCriterion("sex1 >", value, "sex1");
            return (Criteria) this;
        }

        public Criteria andSex1GreaterThanOrEqualTo(Integer value) {
            addCriterion("sex1 >=", value, "sex1");
            return (Criteria) this;
        }

        public Criteria andSex1LessThan(Integer value) {
            addCriterion("sex1 <", value, "sex1");
            return (Criteria) this;
        }

        public Criteria andSex1LessThanOrEqualTo(Integer value) {
            addCriterion("sex1 <=", value, "sex1");
            return (Criteria) this;
        }

        public Criteria andSex1In(List<Integer> values) {
            addCriterion("sex1 in", values, "sex1");
            return (Criteria) this;
        }

        public Criteria andSex1NotIn(List<Integer> values) {
            addCriterion("sex1 not in", values, "sex1");
            return (Criteria) this;
        }

        public Criteria andSex1Between(Integer value1, Integer value2) {
            addCriterion("sex1 between", value1, value2, "sex1");
            return (Criteria) this;
        }

        public Criteria andSex1NotBetween(Integer value1, Integer value2) {
            addCriterion("sex1 not between", value1, value2, "sex1");
            return (Criteria) this;
        }

        public Criteria andPhone1IsNull() {
            addCriterion("phone1 is null");
            return (Criteria) this;
        }

        public Criteria andPhone1IsNotNull() {
            addCriterion("phone1 is not null");
            return (Criteria) this;
        }

        public Criteria andPhone1EqualTo(String value) {
            addCriterion("phone1 =", value, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1NotEqualTo(String value) {
            addCriterion("phone1 <>", value, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1GreaterThan(String value) {
            addCriterion("phone1 >", value, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1GreaterThanOrEqualTo(String value) {
            addCriterion("phone1 >=", value, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1LessThan(String value) {
            addCriterion("phone1 <", value, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1LessThanOrEqualTo(String value) {
            addCriterion("phone1 <=", value, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1Like(String value) {
            addCriterion("phone1 like", value, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1NotLike(String value) {
            addCriterion("phone1 not like", value, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1In(List<String> values) {
            addCriterion("phone1 in", values, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1NotIn(List<String> values) {
            addCriterion("phone1 not in", values, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1Between(String value1, String value2) {
            addCriterion("phone1 between", value1, value2, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1NotBetween(String value1, String value2) {
            addCriterion("phone1 not between", value1, value2, "phone1");
            return (Criteria) this;
        }

        public Criteria andRelation1IsNull() {
            addCriterion("relation1 is null");
            return (Criteria) this;
        }

        public Criteria andRelation1IsNotNull() {
            addCriterion("relation1 is not null");
            return (Criteria) this;
        }

        public Criteria andRelation1EqualTo(String value) {
            addCriterion("relation1 =", value, "relation1");
            return (Criteria) this;
        }

        public Criteria andRelation1NotEqualTo(String value) {
            addCriterion("relation1 <>", value, "relation1");
            return (Criteria) this;
        }

        public Criteria andRelation1GreaterThan(String value) {
            addCriterion("relation1 >", value, "relation1");
            return (Criteria) this;
        }

        public Criteria andRelation1GreaterThanOrEqualTo(String value) {
            addCriterion("relation1 >=", value, "relation1");
            return (Criteria) this;
        }

        public Criteria andRelation1LessThan(String value) {
            addCriterion("relation1 <", value, "relation1");
            return (Criteria) this;
        }

        public Criteria andRelation1LessThanOrEqualTo(String value) {
            addCriterion("relation1 <=", value, "relation1");
            return (Criteria) this;
        }

        public Criteria andRelation1Like(String value) {
            addCriterion("relation1 like", value, "relation1");
            return (Criteria) this;
        }

        public Criteria andRelation1NotLike(String value) {
            addCriterion("relation1 not like", value, "relation1");
            return (Criteria) this;
        }

        public Criteria andRelation1In(List<String> values) {
            addCriterion("relation1 in", values, "relation1");
            return (Criteria) this;
        }

        public Criteria andRelation1NotIn(List<String> values) {
            addCriterion("relation1 not in", values, "relation1");
            return (Criteria) this;
        }

        public Criteria andRelation1Between(String value1, String value2) {
            addCriterion("relation1 between", value1, value2, "relation1");
            return (Criteria) this;
        }

        public Criteria andRelation1NotBetween(String value1, String value2) {
            addCriterion("relation1 not between", value1, value2, "relation1");
            return (Criteria) this;
        }

        public Criteria andName2IsNull() {
            addCriterion("name2 is null");
            return (Criteria) this;
        }

        public Criteria andName2IsNotNull() {
            addCriterion("name2 is not null");
            return (Criteria) this;
        }

        public Criteria andName2EqualTo(String value) {
            addCriterion("name2 =", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2NotEqualTo(String value) {
            addCriterion("name2 <>", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2GreaterThan(String value) {
            addCriterion("name2 >", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2GreaterThanOrEqualTo(String value) {
            addCriterion("name2 >=", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2LessThan(String value) {
            addCriterion("name2 <", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2LessThanOrEqualTo(String value) {
            addCriterion("name2 <=", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2Like(String value) {
            addCriterion("name2 like", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2NotLike(String value) {
            addCriterion("name2 not like", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2In(List<String> values) {
            addCriterion("name2 in", values, "name2");
            return (Criteria) this;
        }

        public Criteria andName2NotIn(List<String> values) {
            addCriterion("name2 not in", values, "name2");
            return (Criteria) this;
        }

        public Criteria andName2Between(String value1, String value2) {
            addCriterion("name2 between", value1, value2, "name2");
            return (Criteria) this;
        }

        public Criteria andName2NotBetween(String value1, String value2) {
            addCriterion("name2 not between", value1, value2, "name2");
            return (Criteria) this;
        }

        public Criteria andSex2IsNull() {
            addCriterion("sex2 is null");
            return (Criteria) this;
        }

        public Criteria andSex2IsNotNull() {
            addCriterion("sex2 is not null");
            return (Criteria) this;
        }

        public Criteria andSex2EqualTo(Integer value) {
            addCriterion("sex2 =", value, "sex2");
            return (Criteria) this;
        }

        public Criteria andSex2NotEqualTo(Integer value) {
            addCriterion("sex2 <>", value, "sex2");
            return (Criteria) this;
        }

        public Criteria andSex2GreaterThan(Integer value) {
            addCriterion("sex2 >", value, "sex2");
            return (Criteria) this;
        }

        public Criteria andSex2GreaterThanOrEqualTo(Integer value) {
            addCriterion("sex2 >=", value, "sex2");
            return (Criteria) this;
        }

        public Criteria andSex2LessThan(Integer value) {
            addCriterion("sex2 <", value, "sex2");
            return (Criteria) this;
        }

        public Criteria andSex2LessThanOrEqualTo(Integer value) {
            addCriterion("sex2 <=", value, "sex2");
            return (Criteria) this;
        }

        public Criteria andSex2In(List<Integer> values) {
            addCriterion("sex2 in", values, "sex2");
            return (Criteria) this;
        }

        public Criteria andSex2NotIn(List<Integer> values) {
            addCriterion("sex2 not in", values, "sex2");
            return (Criteria) this;
        }

        public Criteria andSex2Between(Integer value1, Integer value2) {
            addCriterion("sex2 between", value1, value2, "sex2");
            return (Criteria) this;
        }

        public Criteria andSex2NotBetween(Integer value1, Integer value2) {
            addCriterion("sex2 not between", value1, value2, "sex2");
            return (Criteria) this;
        }

        public Criteria andPhone2IsNull() {
            addCriterion("phone2 is null");
            return (Criteria) this;
        }

        public Criteria andPhone2IsNotNull() {
            addCriterion("phone2 is not null");
            return (Criteria) this;
        }

        public Criteria andPhone2EqualTo(String value) {
            addCriterion("phone2 =", value, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2NotEqualTo(String value) {
            addCriterion("phone2 <>", value, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2GreaterThan(String value) {
            addCriterion("phone2 >", value, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2GreaterThanOrEqualTo(String value) {
            addCriterion("phone2 >=", value, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2LessThan(String value) {
            addCriterion("phone2 <", value, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2LessThanOrEqualTo(String value) {
            addCriterion("phone2 <=", value, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2Like(String value) {
            addCriterion("phone2 like", value, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2NotLike(String value) {
            addCriterion("phone2 not like", value, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2In(List<String> values) {
            addCriterion("phone2 in", values, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2NotIn(List<String> values) {
            addCriterion("phone2 not in", values, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2Between(String value1, String value2) {
            addCriterion("phone2 between", value1, value2, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2NotBetween(String value1, String value2) {
            addCriterion("phone2 not between", value1, value2, "phone2");
            return (Criteria) this;
        }

        public Criteria andRelation2IsNull() {
            addCriterion("relation2 is null");
            return (Criteria) this;
        }

        public Criteria andRelation2IsNotNull() {
            addCriterion("relation2 is not null");
            return (Criteria) this;
        }

        public Criteria andRelation2EqualTo(String value) {
            addCriterion("relation2 =", value, "relation2");
            return (Criteria) this;
        }

        public Criteria andRelation2NotEqualTo(String value) {
            addCriterion("relation2 <>", value, "relation2");
            return (Criteria) this;
        }

        public Criteria andRelation2GreaterThan(String value) {
            addCriterion("relation2 >", value, "relation2");
            return (Criteria) this;
        }

        public Criteria andRelation2GreaterThanOrEqualTo(String value) {
            addCriterion("relation2 >=", value, "relation2");
            return (Criteria) this;
        }

        public Criteria andRelation2LessThan(String value) {
            addCriterion("relation2 <", value, "relation2");
            return (Criteria) this;
        }

        public Criteria andRelation2LessThanOrEqualTo(String value) {
            addCriterion("relation2 <=", value, "relation2");
            return (Criteria) this;
        }

        public Criteria andRelation2Like(String value) {
            addCriterion("relation2 like", value, "relation2");
            return (Criteria) this;
        }

        public Criteria andRelation2NotLike(String value) {
            addCriterion("relation2 not like", value, "relation2");
            return (Criteria) this;
        }

        public Criteria andRelation2In(List<String> values) {
            addCriterion("relation2 in", values, "relation2");
            return (Criteria) this;
        }

        public Criteria andRelation2NotIn(List<String> values) {
            addCriterion("relation2 not in", values, "relation2");
            return (Criteria) this;
        }

        public Criteria andRelation2Between(String value1, String value2) {
            addCriterion("relation2 between", value1, value2, "relation2");
            return (Criteria) this;
        }

        public Criteria andRelation2NotBetween(String value1, String value2) {
            addCriterion("relation2 not between", value1, value2, "relation2");
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

        public Criteria andNote1IsNull() {
            addCriterion("note1 is null");
            return (Criteria) this;
        }

        public Criteria andNote1IsNotNull() {
            addCriterion("note1 is not null");
            return (Criteria) this;
        }

        public Criteria andNote1EqualTo(String value) {
            addCriterion("note1 =", value, "note1");
            return (Criteria) this;
        }

        public Criteria andNote1NotEqualTo(String value) {
            addCriterion("note1 <>", value, "note1");
            return (Criteria) this;
        }

        public Criteria andNote1GreaterThan(String value) {
            addCriterion("note1 >", value, "note1");
            return (Criteria) this;
        }

        public Criteria andNote1GreaterThanOrEqualTo(String value) {
            addCriterion("note1 >=", value, "note1");
            return (Criteria) this;
        }

        public Criteria andNote1LessThan(String value) {
            addCriterion("note1 <", value, "note1");
            return (Criteria) this;
        }

        public Criteria andNote1LessThanOrEqualTo(String value) {
            addCriterion("note1 <=", value, "note1");
            return (Criteria) this;
        }

        public Criteria andNote1Like(String value) {
            addCriterion("note1 like", value, "note1");
            return (Criteria) this;
        }

        public Criteria andNote1NotLike(String value) {
            addCriterion("note1 not like", value, "note1");
            return (Criteria) this;
        }

        public Criteria andNote1In(List<String> values) {
            addCriterion("note1 in", values, "note1");
            return (Criteria) this;
        }

        public Criteria andNote1NotIn(List<String> values) {
            addCriterion("note1 not in", values, "note1");
            return (Criteria) this;
        }

        public Criteria andNote1Between(String value1, String value2) {
            addCriterion("note1 between", value1, value2, "note1");
            return (Criteria) this;
        }

        public Criteria andNote1NotBetween(String value1, String value2) {
            addCriterion("note1 not between", value1, value2, "note1");
            return (Criteria) this;
        }

        public Criteria andNote2IsNull() {
            addCriterion("note2 is null");
            return (Criteria) this;
        }

        public Criteria andNote2IsNotNull() {
            addCriterion("note2 is not null");
            return (Criteria) this;
        }

        public Criteria andNote2EqualTo(String value) {
            addCriterion("note2 =", value, "note2");
            return (Criteria) this;
        }

        public Criteria andNote2NotEqualTo(String value) {
            addCriterion("note2 <>", value, "note2");
            return (Criteria) this;
        }

        public Criteria andNote2GreaterThan(String value) {
            addCriterion("note2 >", value, "note2");
            return (Criteria) this;
        }

        public Criteria andNote2GreaterThanOrEqualTo(String value) {
            addCriterion("note2 >=", value, "note2");
            return (Criteria) this;
        }

        public Criteria andNote2LessThan(String value) {
            addCriterion("note2 <", value, "note2");
            return (Criteria) this;
        }

        public Criteria andNote2LessThanOrEqualTo(String value) {
            addCriterion("note2 <=", value, "note2");
            return (Criteria) this;
        }

        public Criteria andNote2Like(String value) {
            addCriterion("note2 like", value, "note2");
            return (Criteria) this;
        }

        public Criteria andNote2NotLike(String value) {
            addCriterion("note2 not like", value, "note2");
            return (Criteria) this;
        }

        public Criteria andNote2In(List<String> values) {
            addCriterion("note2 in", values, "note2");
            return (Criteria) this;
        }

        public Criteria andNote2NotIn(List<String> values) {
            addCriterion("note2 not in", values, "note2");
            return (Criteria) this;
        }

        public Criteria andNote2Between(String value1, String value2) {
            addCriterion("note2 between", value1, value2, "note2");
            return (Criteria) this;
        }

        public Criteria andNote2NotBetween(String value1, String value2) {
            addCriterion("note2 not between", value1, value2, "note2");
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