package com.jinke.cstsearch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonMethod {

    /**
     *
     * @param conn
     * @param roomGUID
     * @return
     */
    public ResultSet getServiceInfo(Connection conn, String roomGUID) {
        String sql = "select top 1 *  from s_ServiceProcess a join s_ServiceProcessHandle b on a.ServiceProcessGUID=b.ServiceProcessGUID and a.Kinds='产证' and RoomGUID=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, roomGUID);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return rs;
    }

    public ResultSet getContractInfo(Connection conn, String tradeGUID) {
        String sql = "select * from s_Contract where TradeGUID=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, tradeGUID);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return rs;
    }


    public ResultSet getTradeInfo(Connection conn, PreparedStatement ps, ResultSet rs, String cstName, String cardId) {
        String sql = "select * from s_Trade2Cst stc left join s_Order so on so.TradeGUID=stc.TradeGUID left join p_Customer pc on stc.CstGUID=pc.CstGUID where pc.CstName=? and pc.CardID=? and (CloseReason='' or CloseReason='转签约')";
//        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, cstName);
            ps.setString(2, cardId);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }
}
