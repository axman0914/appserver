package boe.b4.appserver.modules.modmes.mapper;

import boe.b4.appserver.modules.modmes.model.Lot;
import oracle.sql.OracleJdbc2SQLInput;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface modmesDAO {
    @Select("SELECT * FROM LOT WHERE LOTNAME = '${lotName}' ")
    List<Lot> getLotList(String lotName);

    @Select("select * from lot a,productspec b where a.productspecname = b.productspecname and lotname = '${lotName}' ")
    List<Map<String, Object>> getLotListMap(String lotName);
}
