package com.uchuang.gamereport.jpa;

@javax.persistence.Entity
@javax.persistence.Table(name = "punish_rule")

public class PunishRule extends stone.dal.common.models.data.BaseDo  {

    private java.lang.String uid;
    private java.lang.String policy;
    private java.lang.String reason;
    private java.lang.Long initDuration;
    private java.math.BigDecimal escalationPercent;


    @javax.persistence.Id
@javax.persistence.Column(name="uid", length=128, nullable=false)
@stone.dal.common.models.annotation.Sequence(generator = "uuid")
    public java.lang.String getUid(){
        return this.uid;
    }

    public void setUid(java.lang.String uid){
        this.uid = uid;
    }
    @javax.persistence.Column(name="policy", length=100, nullable=false)
    public java.lang.String getPolicy(){
        return this.policy;
    }

    public void setPolicy(java.lang.String policy){
        this.policy = policy;
    }
    @javax.persistence.Column(name="reason", length=100, nullable=false)
    public java.lang.String getReason(){
        return this.reason;
    }

    public void setReason(java.lang.String reason){
        this.reason = reason;
    }
    @javax.persistence.Column(name="init_duration", precision=8,scale=0, nullable=false)
    public java.lang.Long getInitDuration(){
        return this.initDuration;
    }

    public void setInitDuration(java.lang.Long initDuration){
        this.initDuration = initDuration;
    }
    @javax.persistence.Column(name="escalation_percent", precision=18,scale=3, nullable=false)
    public java.math.BigDecimal getEscalationPercent(){
        return this.escalationPercent;
    }

    public void setEscalationPercent(java.math.BigDecimal escalationPercent){
        this.escalationPercent = escalationPercent;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        PunishRule obj = (PunishRule) o;
        if (getUid() != null ? !getUid().equals(obj.getUid()) : obj.getUid() != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return getUid() != null ? getUid().hashCode() : 0;
    }

}