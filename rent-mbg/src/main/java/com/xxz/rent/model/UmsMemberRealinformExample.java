package com.xxz.rent.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UmsMemberRealinformExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UmsMemberRealinformExample() {
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

        public Criteria andIdentificationNumberIsNull() {
            addCriterion("identification_number is null");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumberIsNotNull() {
            addCriterion("identification_number is not null");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumberEqualTo(String value) {
            addCriterion("identification_number =", value, "identificationNumber");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumberNotEqualTo(String value) {
            addCriterion("identification_number <>", value, "identificationNumber");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumberGreaterThan(String value) {
            addCriterion("identification_number >", value, "identificationNumber");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumberGreaterThanOrEqualTo(String value) {
            addCriterion("identification_number >=", value, "identificationNumber");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumberLessThan(String value) {
            addCriterion("identification_number <", value, "identificationNumber");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumberLessThanOrEqualTo(String value) {
            addCriterion("identification_number <=", value, "identificationNumber");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumberLike(String value) {
            addCriterion("identification_number like", value, "identificationNumber");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumberNotLike(String value) {
            addCriterion("identification_number not like", value, "identificationNumber");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumberIn(List<String> values) {
            addCriterion("identification_number in", values, "identificationNumber");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumberNotIn(List<String> values) {
            addCriterion("identification_number not in", values, "identificationNumber");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumberBetween(String value1, String value2) {
            addCriterion("identification_number between", value1, value2, "identificationNumber");
            return (Criteria) this;
        }

        public Criteria andIdentificationNumberNotBetween(String value1, String value2) {
            addCriterion("identification_number not between", value1, value2, "identificationNumber");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andEthnicGroupIsNull() {
            addCriterion("ethnic_group is null");
            return (Criteria) this;
        }

        public Criteria andEthnicGroupIsNotNull() {
            addCriterion("ethnic_group is not null");
            return (Criteria) this;
        }

        public Criteria andEthnicGroupEqualTo(String value) {
            addCriterion("ethnic_group =", value, "ethnicGroup");
            return (Criteria) this;
        }

        public Criteria andEthnicGroupNotEqualTo(String value) {
            addCriterion("ethnic_group <>", value, "ethnicGroup");
            return (Criteria) this;
        }

        public Criteria andEthnicGroupGreaterThan(String value) {
            addCriterion("ethnic_group >", value, "ethnicGroup");
            return (Criteria) this;
        }

        public Criteria andEthnicGroupGreaterThanOrEqualTo(String value) {
            addCriterion("ethnic_group >=", value, "ethnicGroup");
            return (Criteria) this;
        }

        public Criteria andEthnicGroupLessThan(String value) {
            addCriterion("ethnic_group <", value, "ethnicGroup");
            return (Criteria) this;
        }

        public Criteria andEthnicGroupLessThanOrEqualTo(String value) {
            addCriterion("ethnic_group <=", value, "ethnicGroup");
            return (Criteria) this;
        }

        public Criteria andEthnicGroupLike(String value) {
            addCriterion("ethnic_group like", value, "ethnicGroup");
            return (Criteria) this;
        }

        public Criteria andEthnicGroupNotLike(String value) {
            addCriterion("ethnic_group not like", value, "ethnicGroup");
            return (Criteria) this;
        }

        public Criteria andEthnicGroupIn(List<String> values) {
            addCriterion("ethnic_group in", values, "ethnicGroup");
            return (Criteria) this;
        }

        public Criteria andEthnicGroupNotIn(List<String> values) {
            addCriterion("ethnic_group not in", values, "ethnicGroup");
            return (Criteria) this;
        }

        public Criteria andEthnicGroupBetween(String value1, String value2) {
            addCriterion("ethnic_group between", value1, value2, "ethnicGroup");
            return (Criteria) this;
        }

        public Criteria andEthnicGroupNotBetween(String value1, String value2) {
            addCriterion("ethnic_group not between", value1, value2, "ethnicGroup");
            return (Criteria) this;
        }

        public Criteria andFacePicIsNull() {
            addCriterion("face_pic is null");
            return (Criteria) this;
        }

        public Criteria andFacePicIsNotNull() {
            addCriterion("face_pic is not null");
            return (Criteria) this;
        }

        public Criteria andFacePicEqualTo(String value) {
            addCriterion("face_pic =", value, "facePic");
            return (Criteria) this;
        }

        public Criteria andFacePicNotEqualTo(String value) {
            addCriterion("face_pic <>", value, "facePic");
            return (Criteria) this;
        }

        public Criteria andFacePicGreaterThan(String value) {
            addCriterion("face_pic >", value, "facePic");
            return (Criteria) this;
        }

        public Criteria andFacePicGreaterThanOrEqualTo(String value) {
            addCriterion("face_pic >=", value, "facePic");
            return (Criteria) this;
        }

        public Criteria andFacePicLessThan(String value) {
            addCriterion("face_pic <", value, "facePic");
            return (Criteria) this;
        }

        public Criteria andFacePicLessThanOrEqualTo(String value) {
            addCriterion("face_pic <=", value, "facePic");
            return (Criteria) this;
        }

        public Criteria andFacePicLike(String value) {
            addCriterion("face_pic like", value, "facePic");
            return (Criteria) this;
        }

        public Criteria andFacePicNotLike(String value) {
            addCriterion("face_pic not like", value, "facePic");
            return (Criteria) this;
        }

        public Criteria andFacePicIn(List<String> values) {
            addCriterion("face_pic in", values, "facePic");
            return (Criteria) this;
        }

        public Criteria andFacePicNotIn(List<String> values) {
            addCriterion("face_pic not in", values, "facePic");
            return (Criteria) this;
        }

        public Criteria andFacePicBetween(String value1, String value2) {
            addCriterion("face_pic between", value1, value2, "facePic");
            return (Criteria) this;
        }

        public Criteria andFacePicNotBetween(String value1, String value2) {
            addCriterion("face_pic not between", value1, value2, "facePic");
            return (Criteria) this;
        }

        public Criteria andIdCardBackPicIsNull() {
            addCriterion("id_card_back_pic is null");
            return (Criteria) this;
        }

        public Criteria andIdCardBackPicIsNotNull() {
            addCriterion("id_card_back_pic is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardBackPicEqualTo(String value) {
            addCriterion("id_card_back_pic =", value, "idCardBackPic");
            return (Criteria) this;
        }

        public Criteria andIdCardBackPicNotEqualTo(String value) {
            addCriterion("id_card_back_pic <>", value, "idCardBackPic");
            return (Criteria) this;
        }

        public Criteria andIdCardBackPicGreaterThan(String value) {
            addCriterion("id_card_back_pic >", value, "idCardBackPic");
            return (Criteria) this;
        }

        public Criteria andIdCardBackPicGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_back_pic >=", value, "idCardBackPic");
            return (Criteria) this;
        }

        public Criteria andIdCardBackPicLessThan(String value) {
            addCriterion("id_card_back_pic <", value, "idCardBackPic");
            return (Criteria) this;
        }

        public Criteria andIdCardBackPicLessThanOrEqualTo(String value) {
            addCriterion("id_card_back_pic <=", value, "idCardBackPic");
            return (Criteria) this;
        }

        public Criteria andIdCardBackPicLike(String value) {
            addCriterion("id_card_back_pic like", value, "idCardBackPic");
            return (Criteria) this;
        }

        public Criteria andIdCardBackPicNotLike(String value) {
            addCriterion("id_card_back_pic not like", value, "idCardBackPic");
            return (Criteria) this;
        }

        public Criteria andIdCardBackPicIn(List<String> values) {
            addCriterion("id_card_back_pic in", values, "idCardBackPic");
            return (Criteria) this;
        }

        public Criteria andIdCardBackPicNotIn(List<String> values) {
            addCriterion("id_card_back_pic not in", values, "idCardBackPic");
            return (Criteria) this;
        }

        public Criteria andIdCardBackPicBetween(String value1, String value2) {
            addCriterion("id_card_back_pic between", value1, value2, "idCardBackPic");
            return (Criteria) this;
        }

        public Criteria andIdCardBackPicNotBetween(String value1, String value2) {
            addCriterion("id_card_back_pic not between", value1, value2, "idCardBackPic");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontPicIsNull() {
            addCriterion("id_card_front_pic is null");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontPicIsNotNull() {
            addCriterion("id_card_front_pic is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontPicEqualTo(String value) {
            addCriterion("id_card_front_pic =", value, "idCardFrontPic");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontPicNotEqualTo(String value) {
            addCriterion("id_card_front_pic <>", value, "idCardFrontPic");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontPicGreaterThan(String value) {
            addCriterion("id_card_front_pic >", value, "idCardFrontPic");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontPicGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_front_pic >=", value, "idCardFrontPic");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontPicLessThan(String value) {
            addCriterion("id_card_front_pic <", value, "idCardFrontPic");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontPicLessThanOrEqualTo(String value) {
            addCriterion("id_card_front_pic <=", value, "idCardFrontPic");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontPicLike(String value) {
            addCriterion("id_card_front_pic like", value, "idCardFrontPic");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontPicNotLike(String value) {
            addCriterion("id_card_front_pic not like", value, "idCardFrontPic");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontPicIn(List<String> values) {
            addCriterion("id_card_front_pic in", values, "idCardFrontPic");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontPicNotIn(List<String> values) {
            addCriterion("id_card_front_pic not in", values, "idCardFrontPic");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontPicBetween(String value1, String value2) {
            addCriterion("id_card_front_pic between", value1, value2, "idCardFrontPic");
            return (Criteria) this;
        }

        public Criteria andIdCardFrontPicNotBetween(String value1, String value2) {
            addCriterion("id_card_front_pic not between", value1, value2, "idCardFrontPic");
            return (Criteria) this;
        }

        public Criteria andIdCardExpiryIsNull() {
            addCriterion("id_card_expiry is null");
            return (Criteria) this;
        }

        public Criteria andIdCardExpiryIsNotNull() {
            addCriterion("id_card_expiry is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardExpiryEqualTo(String value) {
            addCriterion("id_card_expiry =", value, "idCardExpiry");
            return (Criteria) this;
        }

        public Criteria andIdCardExpiryNotEqualTo(String value) {
            addCriterion("id_card_expiry <>", value, "idCardExpiry");
            return (Criteria) this;
        }

        public Criteria andIdCardExpiryGreaterThan(String value) {
            addCriterion("id_card_expiry >", value, "idCardExpiry");
            return (Criteria) this;
        }

        public Criteria andIdCardExpiryGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_expiry >=", value, "idCardExpiry");
            return (Criteria) this;
        }

        public Criteria andIdCardExpiryLessThan(String value) {
            addCriterion("id_card_expiry <", value, "idCardExpiry");
            return (Criteria) this;
        }

        public Criteria andIdCardExpiryLessThanOrEqualTo(String value) {
            addCriterion("id_card_expiry <=", value, "idCardExpiry");
            return (Criteria) this;
        }

        public Criteria andIdCardExpiryLike(String value) {
            addCriterion("id_card_expiry like", value, "idCardExpiry");
            return (Criteria) this;
        }

        public Criteria andIdCardExpiryNotLike(String value) {
            addCriterion("id_card_expiry not like", value, "idCardExpiry");
            return (Criteria) this;
        }

        public Criteria andIdCardExpiryIn(List<String> values) {
            addCriterion("id_card_expiry in", values, "idCardExpiry");
            return (Criteria) this;
        }

        public Criteria andIdCardExpiryNotIn(List<String> values) {
            addCriterion("id_card_expiry not in", values, "idCardExpiry");
            return (Criteria) this;
        }

        public Criteria andIdCardExpiryBetween(String value1, String value2) {
            addCriterion("id_card_expiry between", value1, value2, "idCardExpiry");
            return (Criteria) this;
        }

        public Criteria andIdCardExpiryNotBetween(String value1, String value2) {
            addCriterion("id_card_expiry not between", value1, value2, "idCardExpiry");
            return (Criteria) this;
        }

        public Criteria andIdCardStartDateIsNull() {
            addCriterion("id_card_start_date is null");
            return (Criteria) this;
        }

        public Criteria andIdCardStartDateIsNotNull() {
            addCriterion("id_card_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardStartDateEqualTo(Date value) {
            addCriterion("id_card_start_date =", value, "idCardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdCardStartDateNotEqualTo(Date value) {
            addCriterion("id_card_start_date <>", value, "idCardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdCardStartDateGreaterThan(Date value) {
            addCriterion("id_card_start_date >", value, "idCardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdCardStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("id_card_start_date >=", value, "idCardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdCardStartDateLessThan(Date value) {
            addCriterion("id_card_start_date <", value, "idCardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdCardStartDateLessThanOrEqualTo(Date value) {
            addCriterion("id_card_start_date <=", value, "idCardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdCardStartDateIn(List<Date> values) {
            addCriterion("id_card_start_date in", values, "idCardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdCardStartDateNotIn(List<Date> values) {
            addCriterion("id_card_start_date not in", values, "idCardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdCardStartDateBetween(Date value1, Date value2) {
            addCriterion("id_card_start_date between", value1, value2, "idCardStartDate");
            return (Criteria) this;
        }

        public Criteria andIdCardStartDateNotBetween(Date value1, Date value2) {
            addCriterion("id_card_start_date not between", value1, value2, "idCardStartDate");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressIsNull() {
            addCriterion("current_address is null");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressIsNotNull() {
            addCriterion("current_address is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressEqualTo(String value) {
            addCriterion("current_address =", value, "currentAddress");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressNotEqualTo(String value) {
            addCriterion("current_address <>", value, "currentAddress");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressGreaterThan(String value) {
            addCriterion("current_address >", value, "currentAddress");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressGreaterThanOrEqualTo(String value) {
            addCriterion("current_address >=", value, "currentAddress");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressLessThan(String value) {
            addCriterion("current_address <", value, "currentAddress");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressLessThanOrEqualTo(String value) {
            addCriterion("current_address <=", value, "currentAddress");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressLike(String value) {
            addCriterion("current_address like", value, "currentAddress");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressNotLike(String value) {
            addCriterion("current_address not like", value, "currentAddress");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressIn(List<String> values) {
            addCriterion("current_address in", values, "currentAddress");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressNotIn(List<String> values) {
            addCriterion("current_address not in", values, "currentAddress");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressBetween(String value1, String value2) {
            addCriterion("current_address between", value1, value2, "currentAddress");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressNotBetween(String value1, String value2) {
            addCriterion("current_address not between", value1, value2, "currentAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIsNull() {
            addCriterion("company_address is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIsNotNull() {
            addCriterion("company_address is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressEqualTo(String value) {
            addCriterion("company_address =", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotEqualTo(String value) {
            addCriterion("company_address <>", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressGreaterThan(String value) {
            addCriterion("company_address >", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressGreaterThanOrEqualTo(String value) {
            addCriterion("company_address >=", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLessThan(String value) {
            addCriterion("company_address <", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLessThanOrEqualTo(String value) {
            addCriterion("company_address <=", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLike(String value) {
            addCriterion("company_address like", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotLike(String value) {
            addCriterion("company_address not like", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIn(List<String> values) {
            addCriterion("company_address in", values, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotIn(List<String> values) {
            addCriterion("company_address not in", values, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressBetween(String value1, String value2) {
            addCriterion("company_address between", value1, value2, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotBetween(String value1, String value2) {
            addCriterion("company_address not between", value1, value2, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andBankcardPicIsNull() {
            addCriterion("bankcard_pic is null");
            return (Criteria) this;
        }

        public Criteria andBankcardPicIsNotNull() {
            addCriterion("bankcard_pic is not null");
            return (Criteria) this;
        }

        public Criteria andBankcardPicEqualTo(String value) {
            addCriterion("bankcard_pic =", value, "bankcardPic");
            return (Criteria) this;
        }

        public Criteria andBankcardPicNotEqualTo(String value) {
            addCriterion("bankcard_pic <>", value, "bankcardPic");
            return (Criteria) this;
        }

        public Criteria andBankcardPicGreaterThan(String value) {
            addCriterion("bankcard_pic >", value, "bankcardPic");
            return (Criteria) this;
        }

        public Criteria andBankcardPicGreaterThanOrEqualTo(String value) {
            addCriterion("bankcard_pic >=", value, "bankcardPic");
            return (Criteria) this;
        }

        public Criteria andBankcardPicLessThan(String value) {
            addCriterion("bankcard_pic <", value, "bankcardPic");
            return (Criteria) this;
        }

        public Criteria andBankcardPicLessThanOrEqualTo(String value) {
            addCriterion("bankcard_pic <=", value, "bankcardPic");
            return (Criteria) this;
        }

        public Criteria andBankcardPicLike(String value) {
            addCriterion("bankcard_pic like", value, "bankcardPic");
            return (Criteria) this;
        }

        public Criteria andBankcardPicNotLike(String value) {
            addCriterion("bankcard_pic not like", value, "bankcardPic");
            return (Criteria) this;
        }

        public Criteria andBankcardPicIn(List<String> values) {
            addCriterion("bankcard_pic in", values, "bankcardPic");
            return (Criteria) this;
        }

        public Criteria andBankcardPicNotIn(List<String> values) {
            addCriterion("bankcard_pic not in", values, "bankcardPic");
            return (Criteria) this;
        }

        public Criteria andBankcardPicBetween(String value1, String value2) {
            addCriterion("bankcard_pic between", value1, value2, "bankcardPic");
            return (Criteria) this;
        }

        public Criteria andBankcardPicNotBetween(String value1, String value2) {
            addCriterion("bankcard_pic not between", value1, value2, "bankcardPic");
            return (Criteria) this;
        }

        public Criteria andZmfVideoIsNull() {
            addCriterion("zmf_video is null");
            return (Criteria) this;
        }

        public Criteria andZmfVideoIsNotNull() {
            addCriterion("zmf_video is not null");
            return (Criteria) this;
        }

        public Criteria andZmfVideoEqualTo(String value) {
            addCriterion("zmf_video =", value, "zmfVideo");
            return (Criteria) this;
        }

        public Criteria andZmfVideoNotEqualTo(String value) {
            addCriterion("zmf_video <>", value, "zmfVideo");
            return (Criteria) this;
        }

        public Criteria andZmfVideoGreaterThan(String value) {
            addCriterion("zmf_video >", value, "zmfVideo");
            return (Criteria) this;
        }

        public Criteria andZmfVideoGreaterThanOrEqualTo(String value) {
            addCriterion("zmf_video >=", value, "zmfVideo");
            return (Criteria) this;
        }

        public Criteria andZmfVideoLessThan(String value) {
            addCriterion("zmf_video <", value, "zmfVideo");
            return (Criteria) this;
        }

        public Criteria andZmfVideoLessThanOrEqualTo(String value) {
            addCriterion("zmf_video <=", value, "zmfVideo");
            return (Criteria) this;
        }

        public Criteria andZmfVideoLike(String value) {
            addCriterion("zmf_video like", value, "zmfVideo");
            return (Criteria) this;
        }

        public Criteria andZmfVideoNotLike(String value) {
            addCriterion("zmf_video not like", value, "zmfVideo");
            return (Criteria) this;
        }

        public Criteria andZmfVideoIn(List<String> values) {
            addCriterion("zmf_video in", values, "zmfVideo");
            return (Criteria) this;
        }

        public Criteria andZmfVideoNotIn(List<String> values) {
            addCriterion("zmf_video not in", values, "zmfVideo");
            return (Criteria) this;
        }

        public Criteria andZmfVideoBetween(String value1, String value2) {
            addCriterion("zmf_video between", value1, value2, "zmfVideo");
            return (Criteria) this;
        }

        public Criteria andZmfVideoNotBetween(String value1, String value2) {
            addCriterion("zmf_video not between", value1, value2, "zmfVideo");
            return (Criteria) this;
        }

        public Criteria andStaffPicIsNull() {
            addCriterion("staff_pic is null");
            return (Criteria) this;
        }

        public Criteria andStaffPicIsNotNull() {
            addCriterion("staff_pic is not null");
            return (Criteria) this;
        }

        public Criteria andStaffPicEqualTo(String value) {
            addCriterion("staff_pic =", value, "staffPic");
            return (Criteria) this;
        }

        public Criteria andStaffPicNotEqualTo(String value) {
            addCriterion("staff_pic <>", value, "staffPic");
            return (Criteria) this;
        }

        public Criteria andStaffPicGreaterThan(String value) {
            addCriterion("staff_pic >", value, "staffPic");
            return (Criteria) this;
        }

        public Criteria andStaffPicGreaterThanOrEqualTo(String value) {
            addCriterion("staff_pic >=", value, "staffPic");
            return (Criteria) this;
        }

        public Criteria andStaffPicLessThan(String value) {
            addCriterion("staff_pic <", value, "staffPic");
            return (Criteria) this;
        }

        public Criteria andStaffPicLessThanOrEqualTo(String value) {
            addCriterion("staff_pic <=", value, "staffPic");
            return (Criteria) this;
        }

        public Criteria andStaffPicLike(String value) {
            addCriterion("staff_pic like", value, "staffPic");
            return (Criteria) this;
        }

        public Criteria andStaffPicNotLike(String value) {
            addCriterion("staff_pic not like", value, "staffPic");
            return (Criteria) this;
        }

        public Criteria andStaffPicIn(List<String> values) {
            addCriterion("staff_pic in", values, "staffPic");
            return (Criteria) this;
        }

        public Criteria andStaffPicNotIn(List<String> values) {
            addCriterion("staff_pic not in", values, "staffPic");
            return (Criteria) this;
        }

        public Criteria andStaffPicBetween(String value1, String value2) {
            addCriterion("staff_pic between", value1, value2, "staffPic");
            return (Criteria) this;
        }

        public Criteria andStaffPicNotBetween(String value1, String value2) {
            addCriterion("staff_pic not between", value1, value2, "staffPic");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNull() {
            addCriterion("school is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNotNull() {
            addCriterion("school is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolEqualTo(String value) {
            addCriterion("school =", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotEqualTo(String value) {
            addCriterion("school <>", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThan(String value) {
            addCriterion("school >", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("school >=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThan(String value) {
            addCriterion("school <", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThanOrEqualTo(String value) {
            addCriterion("school <=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLike(String value) {
            addCriterion("school like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotLike(String value) {
            addCriterion("school not like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolIn(List<String> values) {
            addCriterion("school in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotIn(List<String> values) {
            addCriterion("school not in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolBetween(String value1, String value2) {
            addCriterion("school between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotBetween(String value1, String value2) {
            addCriterion("school not between", value1, value2, "school");
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

        public Criteria andMemberTypeIsNull() {
            addCriterion("member_type is null");
            return (Criteria) this;
        }

        public Criteria andMemberTypeIsNotNull() {
            addCriterion("member_type is not null");
            return (Criteria) this;
        }

        public Criteria andMemberTypeEqualTo(Integer value) {
            addCriterion("member_type =", value, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeNotEqualTo(Integer value) {
            addCriterion("member_type <>", value, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeGreaterThan(Integer value) {
            addCriterion("member_type >", value, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_type >=", value, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeLessThan(Integer value) {
            addCriterion("member_type <", value, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeLessThanOrEqualTo(Integer value) {
            addCriterion("member_type <=", value, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeIn(List<Integer> values) {
            addCriterion("member_type in", values, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeNotIn(List<Integer> values) {
            addCriterion("member_type not in", values, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeBetween(Integer value1, Integer value2) {
            addCriterion("member_type between", value1, value2, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("member_type not between", value1, value2, "memberType");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeIsNull() {
            addCriterion("month_income is null");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeIsNotNull() {
            addCriterion("month_income is not null");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeEqualTo(BigDecimal value) {
            addCriterion("month_income =", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeNotEqualTo(BigDecimal value) {
            addCriterion("month_income <>", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeGreaterThan(BigDecimal value) {
            addCriterion("month_income >", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("month_income >=", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeLessThan(BigDecimal value) {
            addCriterion("month_income <", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("month_income <=", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeIn(List<BigDecimal> values) {
            addCriterion("month_income in", values, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeNotIn(List<BigDecimal> values) {
            addCriterion("month_income not in", values, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("month_income between", value1, value2, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("month_income not between", value1, value2, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthConsumeIsNull() {
            addCriterion("month_consume is null");
            return (Criteria) this;
        }

        public Criteria andMonthConsumeIsNotNull() {
            addCriterion("month_consume is not null");
            return (Criteria) this;
        }

        public Criteria andMonthConsumeEqualTo(BigDecimal value) {
            addCriterion("month_consume =", value, "monthConsume");
            return (Criteria) this;
        }

        public Criteria andMonthConsumeNotEqualTo(BigDecimal value) {
            addCriterion("month_consume <>", value, "monthConsume");
            return (Criteria) this;
        }

        public Criteria andMonthConsumeGreaterThan(BigDecimal value) {
            addCriterion("month_consume >", value, "monthConsume");
            return (Criteria) this;
        }

        public Criteria andMonthConsumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("month_consume >=", value, "monthConsume");
            return (Criteria) this;
        }

        public Criteria andMonthConsumeLessThan(BigDecimal value) {
            addCriterion("month_consume <", value, "monthConsume");
            return (Criteria) this;
        }

        public Criteria andMonthConsumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("month_consume <=", value, "monthConsume");
            return (Criteria) this;
        }

        public Criteria andMonthConsumeIn(List<BigDecimal> values) {
            addCriterion("month_consume in", values, "monthConsume");
            return (Criteria) this;
        }

        public Criteria andMonthConsumeNotIn(List<BigDecimal> values) {
            addCriterion("month_consume not in", values, "monthConsume");
            return (Criteria) this;
        }

        public Criteria andMonthConsumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("month_consume between", value1, value2, "monthConsume");
            return (Criteria) this;
        }

        public Criteria andMonthConsumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("month_consume not between", value1, value2, "monthConsume");
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