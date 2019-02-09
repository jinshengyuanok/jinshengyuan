package com.yuan.model.accountManager;

import java.util.ArrayList;
import java.util.List;

public class ConsumeTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConsumeTypeExample() {
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

        public Criteria andConsumeTypeCodeIsNull() {
            addCriterion("consume_type_code is null");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeCodeIsNotNull() {
            addCriterion("consume_type_code is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeCodeEqualTo(String value) {
            addCriterion("consume_type_code =", value, "consumeTypeCode");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeCodeNotEqualTo(String value) {
            addCriterion("consume_type_code <>", value, "consumeTypeCode");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeCodeGreaterThan(String value) {
            addCriterion("consume_type_code >", value, "consumeTypeCode");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("consume_type_code >=", value, "consumeTypeCode");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeCodeLessThan(String value) {
            addCriterion("consume_type_code <", value, "consumeTypeCode");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("consume_type_code <=", value, "consumeTypeCode");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeCodeLike(String value) {
            addCriterion("consume_type_code like", value, "consumeTypeCode");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeCodeNotLike(String value) {
            addCriterion("consume_type_code not like", value, "consumeTypeCode");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeCodeIn(List<String> values) {
            addCriterion("consume_type_code in", values, "consumeTypeCode");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeCodeNotIn(List<String> values) {
            addCriterion("consume_type_code not in", values, "consumeTypeCode");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeCodeBetween(String value1, String value2) {
            addCriterion("consume_type_code between", value1, value2, "consumeTypeCode");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeCodeNotBetween(String value1, String value2) {
            addCriterion("consume_type_code not between", value1, value2, "consumeTypeCode");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeNameIsNull() {
            addCriterion("consume_type_name is null");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeNameIsNotNull() {
            addCriterion("consume_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeNameEqualTo(String value) {
            addCriterion("consume_type_name =", value, "consumeTypeName");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeNameNotEqualTo(String value) {
            addCriterion("consume_type_name <>", value, "consumeTypeName");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeNameGreaterThan(String value) {
            addCriterion("consume_type_name >", value, "consumeTypeName");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("consume_type_name >=", value, "consumeTypeName");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeNameLessThan(String value) {
            addCriterion("consume_type_name <", value, "consumeTypeName");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeNameLessThanOrEqualTo(String value) {
            addCriterion("consume_type_name <=", value, "consumeTypeName");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeNameLike(String value) {
            addCriterion("consume_type_name like", value, "consumeTypeName");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeNameNotLike(String value) {
            addCriterion("consume_type_name not like", value, "consumeTypeName");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeNameIn(List<String> values) {
            addCriterion("consume_type_name in", values, "consumeTypeName");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeNameNotIn(List<String> values) {
            addCriterion("consume_type_name not in", values, "consumeTypeName");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeNameBetween(String value1, String value2) {
            addCriterion("consume_type_name between", value1, value2, "consumeTypeName");
            return (Criteria) this;
        }

        public Criteria andConsumeTypeNameNotBetween(String value1, String value2) {
            addCriterion("consume_type_name not between", value1, value2, "consumeTypeName");
            return (Criteria) this;
        }

        public Criteria andValidFlagIsNull() {
            addCriterion("valid_flag is null");
            return (Criteria) this;
        }

        public Criteria andValidFlagIsNotNull() {
            addCriterion("valid_flag is not null");
            return (Criteria) this;
        }

        public Criteria andValidFlagEqualTo(String value) {
            addCriterion("valid_flag =", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagNotEqualTo(String value) {
            addCriterion("valid_flag <>", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagGreaterThan(String value) {
            addCriterion("valid_flag >", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagGreaterThanOrEqualTo(String value) {
            addCriterion("valid_flag >=", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagLessThan(String value) {
            addCriterion("valid_flag <", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagLessThanOrEqualTo(String value) {
            addCriterion("valid_flag <=", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagLike(String value) {
            addCriterion("valid_flag like", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagNotLike(String value) {
            addCriterion("valid_flag not like", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagIn(List<String> values) {
            addCriterion("valid_flag in", values, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagNotIn(List<String> values) {
            addCriterion("valid_flag not in", values, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagBetween(String value1, String value2) {
            addCriterion("valid_flag between", value1, value2, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagNotBetween(String value1, String value2) {
            addCriterion("valid_flag not between", value1, value2, "validFlag");
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