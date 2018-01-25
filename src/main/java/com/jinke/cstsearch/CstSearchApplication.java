package com.jinke.cstsearch;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jinke.cstsearch.dao.DBConnection;
import com.jinke.cstsearch.model.CstContract;
import com.jinke.cstsearch.model.CstInfo;
import com.jinke.cstsearch.model.CstOrder;
import com.jinke.cstsearch.model.CstVisit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
@RestController
public class CstSearchApplication {
    @Value(value = "${com.jinke.erp.url}")
    private String mySQLUrl;
    @Value(value = "${com.jinke.erp.user}")
    private String mySQLUsername;
    @Value(value = "${com.jinke.erp.password}")
    private String mySQLPassword;
    @Value(value = "${com.jinke.jmj.url}")
    private String jmjSQLUrl;
    @Value(value = "${com.jinke.jmj.user}")
    private String jmjSQLUsername;
    @Value(value = "${com.jinke.jmj.password}")
    private String jmjSQLPassword;

    @RequestMapping(value = "/api/basicinfo", method = RequestMethod.GET)
    public JSONObject cstBasicInfo(@RequestParam("cstname") String cstName, @RequestParam("cardid") String cardId) {
        JSONObject resultJson = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBConnection dbConnection = new DBConnection();
        dbConnection.getConnection(mySQLUrl, mySQLUsername, mySQLPassword, "sql server");
        String sql = "select * from p_customer where CstName=? and CardID=?";
        CstInfo cstInfo = new CstInfo();
        try {
            ps = dbConnection.conn.prepareStatement(sql);
            ps.setString(1, cstName);
            ps.setString(2, cardId);
            rs = ps.executeQuery();
            while (rs.next()) {
                cstInfo.setCstName(rs.getString("CstName"));
                cstInfo.setCardType(rs.getString("CardType"));
                cstInfo.setAddress(rs.getString("Address"));
                cstInfo.setCardID(rs.getString("CardID"));
                cstInfo.setGender(rs.getString("Gender"));
                cstInfo.setEmail(rs.getString("Email"));
                cstInfo.setMobileTel(rs.getString("MobileTel"));
                cstInfo.setCardID15(rs.getString("CardID15"));
            }
            resultJson = JSON.parseObject(JSON.toJSONString(cstInfo));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                dbConnection.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return resultJson;
    }

    @RequestMapping(value = "/api/cstorder", method = RequestMethod.GET)
    public JSONArray cstOrder(@RequestParam("cstname") String cstName, @RequestParam("cardid") String cardId) {
        JSONArray jsonArray = new JSONArray();
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBConnection dbConnection = new DBConnection();
        dbConnection.getConnection(mySQLUrl, mySQLUsername, mySQLPassword, "sql server");
        String sql = "select BldArea,TnArea,BldCjPrice,TnCjPrice,RoomTotal,YwblDate  from s_Order " +
                "where TradeGUID in (select TradeGuid from p_Customer p join s_Trade2Cst tc on p.CstGUID=tc.CstGUID where p.CstName=? and  p.CardID=?) and (CloseReason='' or CloseReason='转签约')";
        CstOrder cstOrder = new CstOrder();
        try {
            ps = dbConnection.conn.prepareStatement(sql);
            ps.setString(1, cstName);
            ps.setString(2, cardId);
            rs = ps.executeQuery();
            while (rs.next()) {
                String bldArea = rs.getString("BldArea");
                String tnArea = rs.getString("TnArea");
                String bldCjPrice = rs.getString("BldCjPrice");
                String tnCjPrice = rs.getString("TnCjPrice");
                String roomTotal = rs.getString("RoomTotal");
                String ywblDate = rs.getString("YwblDate");
                JSONObject jsonObject = new JSONObject();
                cstOrder.setBldArea(bldArea);
                cstOrder.setTnArea(tnArea);
                cstOrder.setBldCjPrice(bldCjPrice);
                cstOrder.setTnCjPrice(tnCjPrice);
                cstOrder.setRoomTotal(roomTotal);
                cstOrder.setYwblDate(ywblDate);
                jsonObject = JSON.parseObject(JSON.toJSONString(cstOrder));
                jsonArray.add(jsonObject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                dbConnection.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return jsonArray;
    }

    @RequestMapping(value = "/api/cstvisit", method = RequestMethod.GET)
    public JSONArray cstVisit(@RequestParam("cstname") String cstName, @RequestParam("cardid") String cardId) {
        JSONArray jsonArray = new JSONArray();
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        DBConnection dbConnection = new DBConnection();
        DBConnection dbConnection2 = new DBConnection();
        dbConnection.getConnection(mySQLUrl, mySQLUsername, mySQLPassword, "sql server");
        dbConnection2.getConnection(jmjSQLUrl, jmjSQLUsername, jmjSQLPassword, "sql server");
        String sql1 = "select * from p_customer where CstName=? and CardID=?";
        String sql2 = "select c.CstName ,c.Mobile ,c.CheckinDate ,m.Name as '认知途径'  from msCheckin c  join msMysoftCategory m on c.Way =m.GID  " +
                "where Mobile in (?,?,?)";
        CstVisit cstVisit = new CstVisit();
        try {
            ps = dbConnection.conn.prepareStatement(sql1);
            ps2 = dbConnection2.conn.prepareStatement(sql2);
            ps.setString(1, cstName);
            ps.setString(2, cardId);
            rs = ps.executeQuery();
            String mobileTel = null;
            String homeTel = null;
            String officeTel = null;
            if (rs.next()) {
                mobileTel = rs.getString("MobileTel");
                homeTel = rs.getString("HomeTel");
                officeTel = rs.getString("OfficeTel");
            }
            if (mobileTel == null || mobileTel.equals("")) {
                mobileTel = "NOTEL$$$";
            }
            if (homeTel == null || homeTel.equals("")) {
                homeTel = "NOTEL$$$";
            }
            if (officeTel == null || officeTel.equals("")) {
                officeTel = "NOTEL$$$";
            }
            ps2.setString(1, mobileTel);
            ps2.setString(2, homeTel);
            ps2.setString(3, officeTel);
            rs2 = ps2.executeQuery();
            while (rs2.next()) {
                JSONObject jsonObject = new JSONObject();
                cstVisit.setCstName(rs2.getString("CstName"));
                cstVisit.setVisitTime(rs2.getString("CheckinDate"));
                cstVisit.setVisitWay(rs2.getString("认知途径"));
                cstVisit.setMobile(rs2.getString("Mobile"));
                jsonObject = JSON.parseObject(JSON.toJSONString(cstVisit));
                jsonArray.add(jsonObject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs2 != null) {
                    rs2.close();
                }
                if (ps2 != null) {
                    ps2.close();
                }
                dbConnection.closeConnection();
                dbConnection2.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return jsonArray;
    }

    @RequestMapping(value = "/api/cstcontract", method = RequestMethod.GET)
    public JSONArray cstContract(@RequestParam("cstname") String cstName, @RequestParam("cardid") String cardId) {
        JSONArray jsonArray = new JSONArray();
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBConnection dbConnection = new DBConnection();
        dbConnection.getConnection(mySQLUrl, mySQLUsername, mySQLPassword, "sql server");
        String sql = "select BldArea,TnArea,BldCjPrice,TnCjPrice,HtTotal,SjBcTotal as '补差金额',ContractDate,JFDate,qyyxType as '全员营销类型'  from s_Contract " +
                "where  Status='激活' and TradeGUID=(select TradeGuid from p_Customer p join s_Trade2Cst tc on p.CstGUID=tc.CstGUID where p.CstName=? and p.CardID=?)\n";
        CstContract cstContract = new CstContract();
        try {
            ps = dbConnection.conn.prepareStatement(sql);
            ps.setString(1, cstName);
            ps.setString(2, cardId);
            rs = ps.executeQuery();
            while (rs.next()) {
                JSONObject jsonObject = new JSONObject();
                cstContract.setCstName(cstName);
                cstContract.setCardId(cardId);
                cstContract.setBldArea(rs.getString("BldArea"));
                cstContract.setBldCjPrice(rs.getString("BldCjPrice"));
                cstContract.setTnArea(rs.getString("TnArea"));
                cstContract.setTnCjPrice(rs.getString("TnCjPrice"));
                cstContract.setContractDate(rs.getString("ContractDate"));
                cstContract.setHtTotal(rs.getString("HtTotal"));
                cstContract.setJFDate(rs.getString("JFDate"));
                cstContract.setQyyxType(rs.getString("全员营销类型"));
                cstContract.setSjBcTotal(rs.getString("补差金额"));

                jsonArray.add(JSON.parseObject(JSON.toJSONString(cstContract)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                dbConnection.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return jsonArray;
    }


    @RequestMapping(value = "/api/cstservicepro", method = RequestMethod.GET)
    public JSONArray cstServicePro(@RequestParam("cstname") String cstName, @RequestParam("cardid") String cardId) {
        JSONArray jsonArray = new JSONArray();

        return jsonArray;
    }

    @RequestMapping(value = "/api/cstjfpro", method = RequestMethod.GET)
    public JSONArray cstjfpro(@RequestParam("cstname") String cstName, @RequestParam("cardid") String cardId) {
        JSONArray jsonArray = new JSONArray();
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBConnection dbConnection = new DBConnection();
        dbConnection.getConnection(mySQLUrl, mySQLUsername, mySQLPassword, "sql server");
        String sql = "select BldArea,TnArea,BldCjPrice,TnCjPrice,HtTotal,SjBcTotal as '补差金额',ContractDate,JFDate,qyyxType as '全员营销类型'  from s_Contract " +
                "where  Status='激活' and TradeGUID=(select TradeGuid from p_Customer p join s_Trade2Cst tc on p.CstGUID=tc.CstGUID where p.CstName=? and p.CardID=?)\n";
        CstContract cstContract = new CstContract();
        try {
            ps = dbConnection.conn.prepareStatement(sql);
            ps.setString(1, cstName);
            ps.setString(2, cardId);
            rs = ps.executeQuery();
            while (rs.next()) {
                JSONObject jsonObject = new JSONObject();
                String jfDate = rs.getString("JFDate");

                cstContract.setCstName(cstName);
                cstContract.setCardId(cardId);
                cstContract.setBldArea(rs.getString("BldArea"));
                cstContract.setBldCjPrice(rs.getString("BldCjPrice"));
                cstContract.setTnArea(rs.getString("TnArea"));
                cstContract.setTnCjPrice(rs.getString("TnCjPrice"));
                cstContract.setContractDate(rs.getString("ContractDate"));
                cstContract.setHtTotal(rs.getString("HtTotal"));
                cstContract.setJFDate(rs.getString("JFDate"));
                cstContract.setQyyxType(rs.getString("全员营销类型"));
                cstContract.setSjBcTotal(rs.getString("补差金额"));

                jsonArray.add(JSON.parseObject(JSON.toJSONString(cstContract)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                dbConnection.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return jsonArray;
    }


    @RequestMapping(value = "/api/cstdata", method = RequestMethod.GET)
    public JSONArray csttest(@RequestParam("cstname") String cstName, @RequestParam("cardid") String cardId) {
        JSONArray resultJSON = new JSONArray();
        //判断有几条成交信息
        int count = 2;
        for (int i = 1; i<= count; i++){
            JSONArray jsonArray = new JSONArray();
            JSONArray cstVisit = cstVisit(cstName, cardId); //到访
            JSONArray cstOrder = cstOrder(cstName, cardId); //认购
            JSONArray cstContract = cstContract(cstName, cardId); //合同
            JSONArray cstServicePro = cstServicePro(cstName, cardId); //产证
            JSONArray cstJFInfo = cstjfpro(cstName, cardId); //交房

            jsonArray.add(cstVisit);
            jsonArray.add(cstOrder);
            jsonArray.add(cstContract);
            jsonArray.add(cstServicePro);
            jsonArray.add(cstJFInfo);
            resultJSON.add(jsonArray);
        }

        return resultJSON;
    }

    public static void main(String[] args) {
        SpringApplication.run(CstSearchApplication.class, args);
    }
}
