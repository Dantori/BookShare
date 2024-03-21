package ru.trofimov.bookshare.domain.swap;

import jakarta.persistence.*;

@Entity
@Table(name = "t_swap", schema = "s_bookshare")
public class Swap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long reqId;
    private Long reqBookId;
    private Long resId;
    private Long resBookId;

    public Swap(Long reqId, Long reqBookId, Long resId, Long resBookId) {
        this.reqId = reqId;
        this.reqBookId = reqBookId;
        this.resId = resId;
        this.resBookId = resBookId;
    }

    public Swap() {}
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getReqId() {
        return reqId;
    }
    public Long getReqBookId() {
        return reqBookId;
    }
    public Long getResId() {
        return resId;
    }
    public Long getResBookId() {
        return resBookId;
    }
}
