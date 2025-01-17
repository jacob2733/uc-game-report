package com.uchuang.gamereport.jpa;

import io.swagger.annotations.ApiModelProperty;

@javax.persistence.Entity
@javax.persistence.Table(name = "report")

public class Report extends stone.dal.common.models.data.BaseDo {

  @ApiModelProperty(value = "Report ID", hidden = true)
  private java.lang.String uid;

  @ApiModelProperty(value = "Player ID")
  private java.lang.String playerUid;

  @ApiModelProperty(value = "Player Name")
  private java.lang.String playerName;

  @ApiModelProperty(value = "Img")
  private java.lang.String img;

  @ApiModelProperty(value = "Processed")
  private java.lang.Boolean processed;

  @ApiModelProperty(value = "Type", allowableValues = "")
  private java.lang.String type;

  @ApiModelProperty(value = "Punish Result", allowableValues = "")
  private java.lang.String punishResult;

  @ApiModelProperty(value = "Processed")
  private java.lang.Long duration;

  @ApiModelProperty(value = "Punish Rule ID")
  private java.lang.String punishRuleUid;


  @ApiModelProperty(value = "Reporter ID")
  private java.lang.String reporterUid;

  @ApiModelProperty(value = "Reporter Is Anonymous")
  private java.lang.Boolean isAnonymous;

  @javax.persistence.Id
  @javax.persistence.Column(name = "uid", length = 128, nullable = false)
  @stone.dal.common.models.annotation.Sequence(generator = "uuid")
  public java.lang.String getUid() {
    return this.uid;
  }

  public void setUid(java.lang.String uid) {
    this.uid = uid;
  }

  @javax.persistence.Column(name = "player_uid", length = 100, nullable = false)
  public java.lang.String getPlayerUid() {
    return this.playerUid;
  }

  public void setPlayerUid(java.lang.String playerUid) {
    this.playerUid = playerUid;
  }

  @javax.persistence.Column(name = "player_name", length = 100, nullable = false)
  public java.lang.String getPlayerName() {
    return this.playerName;
  }

  public void setPlayerName(java.lang.String playerName) {
    this.playerName = playerName;
  }

  @javax.persistence.Column(name = "img", length = 500, nullable = false)
  public java.lang.String getImg() {
    return this.img;
  }

  public void setImg(java.lang.String img) {
    this.img = img;
  }

  @javax.persistence.Column(name = "processed")
  public java.lang.Boolean getProcessed() {
    return this.processed;
  }

  public void setProcessed(java.lang.Boolean processed) {
    this.processed = processed;
  }

  @javax.persistence.Column(name = "type", length = 100)
  public java.lang.String getType() {
    return this.type;
  }

  public void setType(java.lang.String type) {
    this.type = type;
  }

  @javax.persistence.Column(name = "punish_result", length = 100)
  public java.lang.String getPunishResult() {
    return this.punishResult;
  }

  public void setPunishResult(java.lang.String punishResult) {
    this.punishResult = punishResult;
  }

  @javax.persistence.Column(name = "duration", precision = 10, scale = 0)
  public java.lang.Long getDuration() {
    return this.duration;
  }

  public void setDuration(java.lang.Long duration) {
    this.duration = duration;
  }

  @javax.persistence.Column(name = "punish_rule_uid", length = 128)
  public java.lang.String getPunishRuleUid() {
    return this.punishRuleUid;
  }

  public void setPunishRuleUid(java.lang.String punishRuleUid) {
    this.punishRuleUid = punishRuleUid;
  }

  @javax.persistence.Column(name = "reporter_uid", length = 128)
  public java.lang.String getReporterUid() {
    return this.reporterUid;
  }

  public void setReporterUid(java.lang.String reporterUid) {
    this.reporterUid = reporterUid;
  }

  @javax.persistence.Column(name = "is_anonymous")
  public java.lang.Boolean getIsAnonymous() {
    return this.isAnonymous;
  }

  public void setIsAnonymous(java.lang.Boolean isAnonymous) {
    this.isAnonymous = isAnonymous;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null)
      return false;

    Report obj = (Report) o;
    if (getUid() != null ? !getUid().equals(obj.getUid()) : obj.getUid() != null)
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    return getUid() != null ? getUid().hashCode() : 0;
  }

}