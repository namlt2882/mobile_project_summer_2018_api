package fptu.summer.model;
// Generated Jun 3, 2018 2:37:40 PM by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import fptu.summer.model.enumeration.TransactionGroupStatus;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TransactionGroup generated by hbm2java
 */
public class TransactionGroup implements java.io.Serializable {

    @JsonProperty("local_id")
    private Long localId;
    @JsonProperty("server_id")
    private Long id;
    private Ledger ledger;
    private String name;
    private int transactionType;
    private Date lastUpdate;
    private Date insertDate;
    private int status = TransactionGroupStatus.ENABLE.getStatus();
    @JsonIgnore
    private Set<TransactionGroup> childrenGroups = new HashSet<>(0);

    public TransactionGroup() {
    }

    public Long getLocalId() {
        return localId;
    }

    public void setLocalId(Long localId) {
        this.localId = localId;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ledger getLedger() {
        return this.ledger;
    }

    public void setLedger(Ledger ledger) {
        this.ledger = ledger;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTransactionType() {
        return this.transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

    public Date getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<TransactionGroup> getChildrenGroups() {
        return childrenGroups;
    }

    public void setChildrenGroups(Set<TransactionGroup> childrenGroups) {
        this.childrenGroups = childrenGroups;
    }

}
