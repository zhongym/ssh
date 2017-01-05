package com.zhong.module.docking.service;

import com.zhong.commons.base.DockingEntityManager;
import com.zhong.module.docking.dao.B2bNoteDao;
import com.zhong.module.docking.domain.B2bNote;
import com.zhong.service.docking.IB2bNoteService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by zhong on 2016/11/7.
 */
@Service
public class B2bNoteService extends DockingEntityManager<B2bNoteDao, B2bNote, Integer> implements IB2bNoteService {

    private static Logger logger = Logger.getLogger(B2bNoteService.class);

    public static final int NOT_PROCESSED = 0;
    @Override
    public int sendNote(int type,String companyCode) {
        B2bNote ecNote = new B2bNote();
        ecNote.setActionType(type);
        ecNote.setNoteTime(new Date());
        ecNote.setCompanyCode(companyCode);
        ecNote.setHandleStatusCode(NOT_PROCESSED);
        insert(ecNote);
        logger.info("send note: " + ecNote);
        return ecNote.getB2bNoteId();
    }
}