package boe.b4.appserver.modules.common.service;

import boe.b4.appserver.modules.common.model.query.MWMS_QueryObj;

import java.util.List;

public interface TibQueryService {

    List<MWMS_QueryObj> query(MWMS_QueryObj MWMSQueryObj) throws Exception;
}
