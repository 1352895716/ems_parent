package com.ems.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalaryExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNull() {
            addCriterion("staff_id is null");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNotNull() {
            addCriterion("staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andStaffIdEqualTo(Integer value) {
            addCriterion("staff_id =", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotEqualTo(Integer value) {
            addCriterion("staff_id <>", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThan(Integer value) {
            addCriterion("staff_id >", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("staff_id >=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThan(Integer value) {
            addCriterion("staff_id <", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThanOrEqualTo(Integer value) {
            addCriterion("staff_id <=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdIn(List<Integer> values) {
            addCriterion("staff_id in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotIn(List<Integer> values) {
            addCriterion("staff_id not in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdBetween(Integer value1, Integer value2) {
            addCriterion("staff_id between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotBetween(Integer value1, Integer value2) {
            addCriterion("staff_id not between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andBasicIsNull() {
            addCriterion("basic is null");
            return (Criteria) this;
        }

        public Criteria andBasicIsNotNull() {
            addCriterion("basic is not null");
            return (Criteria) this;
        }

        public Criteria andBasicEqualTo(Float value) {
            addCriterion("basic =", value, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicNotEqualTo(Float value) {
            addCriterion("basic <>", value, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicGreaterThan(Float value) {
            addCriterion("basic >", value, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicGreaterThanOrEqualTo(Float value) {
            addCriterion("basic >=", value, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicLessThan(Float value) {
            addCriterion("basic <", value, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicLessThanOrEqualTo(Float value) {
            addCriterion("basic <=", value, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicIn(List<Float> values) {
            addCriterion("basic in", values, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicNotIn(List<Float> values) {
            addCriterion("basic not in", values, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicBetween(Float value1, Float value2) {
            addCriterion("basic between", value1, value2, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicNotBetween(Float value1, Float value2) {
            addCriterion("basic not between", value1, value2, "basic");
            return (Criteria) this;
        }

        public Criteria andEatIsNull() {
            addCriterion("eat is null");
            return (Criteria) this;
        }

        public Criteria andEatIsNotNull() {
            addCriterion("eat is not null");
            return (Criteria) this;
        }

        public Criteria andEatEqualTo(Float value) {
            addCriterion("eat =", value, "eat");
            return (Criteria) this;
        }

        public Criteria andEatNotEqualTo(Float value) {
            addCriterion("eat <>", value, "eat");
            return (Criteria) this;
        }

        public Criteria andEatGreaterThan(Float value) {
            addCriterion("eat >", value, "eat");
            return (Criteria) this;
        }

        public Criteria andEatGreaterThanOrEqualTo(Float value) {
            addCriterion("eat >=", value, "eat");
            return (Criteria) this;
        }

        public Criteria andEatLessThan(Float value) {
            addCriterion("eat <", value, "eat");
            return (Criteria) this;
        }

        public Criteria andEatLessThanOrEqualTo(Float value) {
            addCriterion("eat <=", value, "eat");
            return (Criteria) this;
        }

        public Criteria andEatIn(List<Float> values) {
            addCriterion("eat in", values, "eat");
            return (Criteria) this;
        }

        public Criteria andEatNotIn(List<Float> values) {
            addCriterion("eat not in", values, "eat");
            return (Criteria) this;
        }

        public Criteria andEatBetween(Float value1, Float value2) {
            addCriterion("eat between", value1, value2, "eat");
            return (Criteria) this;
        }

        public Criteria andEatNotBetween(Float value1, Float value2) {
            addCriterion("eat not between", value1, value2, "eat");
            return (Criteria) this;
        }

        public Criteria andHouseIsNull() {
            addCriterion("house is null");
            return (Criteria) this;
        }

        public Criteria andHouseIsNotNull() {
            addCriterion("house is not null");
            return (Criteria) this;
        }

        public Criteria andHouseEqualTo(Float value) {
            addCriterion("house =", value, "house");
            return (Criteria) this;
        }

        public Criteria andHouseNotEqualTo(Float value) {
            addCriterion("house <>", value, "house");
            return (Criteria) this;
        }

        public Criteria andHouseGreaterThan(Float value) {
            addCriterion("house >", value, "house");
            return (Criteria) this;
        }

        public Criteria andHouseGreaterThanOrEqualTo(Float value) {
            addCriterion("house >=", value, "house");
            return (Criteria) this;
        }

        public Criteria andHouseLessThan(Float value) {
            addCriterion("house <", value, "house");
            return (Criteria) this;
        }

        public Criteria andHouseLessThanOrEqualTo(Float value) {
            addCriterion("house <=", value, "house");
            return (Criteria) this;
        }

        public Criteria andHouseIn(List<Float> values) {
            addCriterion("house in", values, "house");
            return (Criteria) this;
        }

        public Criteria andHouseNotIn(List<Float> values) {
            addCriterion("house not in", values, "house");
            return (Criteria) this;
        }

        public Criteria andHouseBetween(Float value1, Float value2) {
            addCriterion("house between", value1, value2, "house");
            return (Criteria) this;
        }

        public Criteria andHouseNotBetween(Float value1, Float value2) {
            addCriterion("house not between", value1, value2, "house");
            return (Criteria) this;
        }

        public Criteria andDutyIsNull() {
            addCriterion("duty is null");
            return (Criteria) this;
        }

        public Criteria andDutyIsNotNull() {
            addCriterion("duty is not null");
            return (Criteria) this;
        }

        public Criteria andDutyEqualTo(Float value) {
            addCriterion("duty =", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotEqualTo(Float value) {
            addCriterion("duty <>", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyGreaterThan(Float value) {
            addCriterion("duty >", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyGreaterThanOrEqualTo(Float value) {
            addCriterion("duty >=", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyLessThan(Float value) {
            addCriterion("duty <", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyLessThanOrEqualTo(Float value) {
            addCriterion("duty <=", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyIn(List<Float> values) {
            addCriterion("duty in", values, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotIn(List<Float> values) {
            addCriterion("duty not in", values, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyBetween(Float value1, Float value2) {
            addCriterion("duty between", value1, value2, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotBetween(Float value1, Float value2) {
            addCriterion("duty not between", value1, value2, "duty");
            return (Criteria) this;
        }

        public Criteria andScotIsNull() {
            addCriterion("scot is null");
            return (Criteria) this;
        }

        public Criteria andScotIsNotNull() {
            addCriterion("scot is not null");
            return (Criteria) this;
        }

        public Criteria andScotEqualTo(Float value) {
            addCriterion("scot =", value, "scot");
            return (Criteria) this;
        }

        public Criteria andScotNotEqualTo(Float value) {
            addCriterion("scot <>", value, "scot");
            return (Criteria) this;
        }

        public Criteria andScotGreaterThan(Float value) {
            addCriterion("scot >", value, "scot");
            return (Criteria) this;
        }

        public Criteria andScotGreaterThanOrEqualTo(Float value) {
            addCriterion("scot >=", value, "scot");
            return (Criteria) this;
        }

        public Criteria andScotLessThan(Float value) {
            addCriterion("scot <", value, "scot");
            return (Criteria) this;
        }

        public Criteria andScotLessThanOrEqualTo(Float value) {
            addCriterion("scot <=", value, "scot");
            return (Criteria) this;
        }

        public Criteria andScotIn(List<Float> values) {
            addCriterion("scot in", values, "scot");
            return (Criteria) this;
        }

        public Criteria andScotNotIn(List<Float> values) {
            addCriterion("scot not in", values, "scot");
            return (Criteria) this;
        }

        public Criteria andScotBetween(Float value1, Float value2) {
            addCriterion("scot between", value1, value2, "scot");
            return (Criteria) this;
        }

        public Criteria andScotNotBetween(Float value1, Float value2) {
            addCriterion("scot not between", value1, value2, "scot");
            return (Criteria) this;
        }

        public Criteria andAdditionalBenefitsIsNull() {
            addCriterion("additional_benefits is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalBenefitsIsNotNull() {
            addCriterion("additional_benefits is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalBenefitsEqualTo(Float value) {
            addCriterion("additional_benefits =", value, "additionalBenefits");
            return (Criteria) this;
        }

        public Criteria andAdditionalBenefitsNotEqualTo(Float value) {
            addCriterion("additional_benefits <>", value, "additionalBenefits");
            return (Criteria) this;
        }

        public Criteria andAdditionalBenefitsGreaterThan(Float value) {
            addCriterion("additional_benefits >", value, "additionalBenefits");
            return (Criteria) this;
        }

        public Criteria andAdditionalBenefitsGreaterThanOrEqualTo(Float value) {
            addCriterion("additional_benefits >=", value, "additionalBenefits");
            return (Criteria) this;
        }

        public Criteria andAdditionalBenefitsLessThan(Float value) {
            addCriterion("additional_benefits <", value, "additionalBenefits");
            return (Criteria) this;
        }

        public Criteria andAdditionalBenefitsLessThanOrEqualTo(Float value) {
            addCriterion("additional_benefits <=", value, "additionalBenefits");
            return (Criteria) this;
        }

        public Criteria andAdditionalBenefitsIn(List<Float> values) {
            addCriterion("additional_benefits in", values, "additionalBenefits");
            return (Criteria) this;
        }

        public Criteria andAdditionalBenefitsNotIn(List<Float> values) {
            addCriterion("additional_benefits not in", values, "additionalBenefits");
            return (Criteria) this;
        }

        public Criteria andAdditionalBenefitsBetween(Float value1, Float value2) {
            addCriterion("additional_benefits between", value1, value2, "additionalBenefits");
            return (Criteria) this;
        }

        public Criteria andAdditionalBenefitsNotBetween(Float value1, Float value2) {
            addCriterion("additional_benefits not between", value1, value2, "additionalBenefits");
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

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(Float value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(Float value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(Float value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(Float value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(Float value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(Float value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<Float> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<Float> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(Float value1, Float value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(Float value1, Float value2) {
            addCriterion("total not between", value1, value2, "total");
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