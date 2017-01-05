package com.zhong.service.docking;

import com.zhong.commons.base.IDockingEntityManager;
import com.zhong.module.docking.domain.B2bNote;

/**
 * Created by zhong on 2016/11/7.
 */
public interface IB2bNoteService extends IDockingEntityManager<B2bNote, Integer> {
    int sendNote(int type,String companyCode);
}

