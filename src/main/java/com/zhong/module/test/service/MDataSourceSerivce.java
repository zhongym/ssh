package com.zhong.module.test.service;

import com.zhong.module.docking.domain.B2bNote;
import com.zhong.service.docking.IB2bNoteService;
import com.zhong.service.test.IMDataSourceSerivce;
import com.zhong.service.test.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by zhong on 2016/11/7.
 */
@Service
public class MDataSourceSerivce implements IMDataSourceSerivce {

    @Autowired
    private IB2bNoteService bNoteService;

    @Autowired
    private ITestService testService;

    @Transactional("dockingTransactionManager")
    public void testMdata() throws Exception {
        B2bNote b2bNote=new B2bNote();
        b2bNote.setActionType(1);
        b2bNote.setNoteTime(new Date());
        b2bNote.setHandleStatusCode(1);
        b2bNote.setCompanyCode("123");
        bNoteService.insert(b2bNote);

//        testService.save(new Test("1231231","sfdsaf",new Date()));
    }
}
