package com.suresh.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class SSNGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object)  {
		
		String prefix="42312";
		String suffix="";
		try {
			Connection con= session.connection();
			Statement stmt = con.createStatement();
			String sql="select enroll_id_seq.nextval from dual";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				int seqval = rs.getInt(1);
				suffix=String.valueOf(seqval);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return prefix+suffix;
	}

}
