package com.zhong.module.docking.domain;

import cn.org.rapid_framework.util.DateConvertUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.*;

/**
 * Created by zhong on 2016/11/7.
 */
@Entity
@Table(name = "B2B_NOTE")
public class B2bNote  {
    protected static final String DATE_FORMAT = "yyyy-MM-dd";

    protected static final String TIME_FORMAT = "HH:mm:ss";

    protected static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    protected static final String DATE_TIME_FORMAT2 = "yyyy-MM-dd HH:mm";

    protected static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";

    protected static final String COMPANT_TIMESTAMP_MM_FORMAT = "yy-MM-dd HH:mm";
    /**
     * b2bNoteId	   db_column: B2B_NOTE_ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "B2B_NOTE_ID", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
    private Integer b2bNoteId;
    /**
     * actionType	   db_column: ActionType
     */
    @Column(name = "ACTION_TYPE", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
    private int actionType;
    /**
     * noteTime       db_column: NoteTime
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "NOTE_TIME", unique = false, nullable = false, insertable = true, updatable = true, length = 0)
    private java.util.Date noteTime;
    /**
     * notes	   db_column: Notes
     */
    @Column(name = "NOTES", unique = false, nullable = true, insertable = true, updatable = true, length = 60)
    private String notes;
    /**
     * ecNoteId	   db_column: EcNoteId
     */
    @Column(name = "HANDLE_STATUS_CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 1)
    private Integer handleStatusCode;
    /**
     * handleTime       db_column: HandleTime
     */
    @Temporal(TemporalType.TIMESTAMP) //注意:在ORACLE上DATE是有时间的，只有通过映射到TIMESTAMP才能拿出来
    @Column(name = "HANDLE_TIME", unique = false, nullable = true, insertable = true, updatable = true, length = 0)
    private java.util.Date handleTime;

    /**
     * companyCode	   db_column: COMPANY_CODE
     */
    @Column(name = "COMPANY_CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 11)
    private String companyCode;
    //columns END

    public B2bNote(){
    }

    public B2bNote(
            Integer b2bNoteId
    ){
        this.b2bNoteId = b2bNoteId;
    }

    public Integer getB2bNoteId() {
        return b2bNoteId;
    }

    public void setB2bNoteId(Integer ecNoteId) {
        this.b2bNoteId = ecNoteId;
    }

    public int getActionType() {
        return actionType;
    }

    public void setActionType(int actionType) {
        this.actionType = actionType;
    }

    public java.util.Date getNoteTime() {
        return noteTime;
    }

    public void setNoteTime(java.util.Date noteTime) {
        this.noteTime = noteTime;
    }

    public String getNotes() {
        return notes == null ? "" : notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getHandleStatusCode() {
        return handleStatusCode;
    }

    public void setHandleStatusCode(Integer handleStatusCode) {
        this.handleStatusCode = handleStatusCode;
    }

    public java.util.Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(java.util.Date handleTime) {
        this.handleTime = handleTime;
    }

    public String getNoteTimeString() {
        return DateConvertUtils.format(getNoteTime(), DATE_TIME_FORMAT);
    }
    public void setNoteTimeString(String value) {
        setNoteTime(DateConvertUtils.parse(value, DATE_TIME_FORMAT, java.util.Date.class));
    }

    public String getHandleTimeString() {
        return DateConvertUtils.format(getHandleTime(), DATE_TIME_FORMAT);
    }
    public void setHandleTimeString(String value) {
        setHandleTime(DateConvertUtils.parse(value, DATE_TIME_FORMAT, java.util.Date.class));
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("B2bNoteId", getB2bNoteId())
                .append("ActionType", getActionType())
                .append("NoteTime",getNoteTimeString())
                .append("Notes",getNotes())
                .append("HandleStatusCode",getHandleStatusCode())
                .append("HandleTime",getHandleTimeString())
                .toString();
    }


    //---------------------------------

    public int hashCode() {
        return new HashCodeBuilder()
                .append(getB2bNoteId())
                .toHashCode();
    }

    public boolean equals(Object obj) {
        if(this.getB2bNoteId() == null){
            return false;
        }
        if(!(obj instanceof B2bNote)){
            return false;
        }
        if(this == obj) {
            return true;
        }
        B2bNote other = (B2bNote)obj;
        return new EqualsBuilder()
                .append(getB2bNoteId(),other.getB2bNoteId())
                .isEquals();
    }

}