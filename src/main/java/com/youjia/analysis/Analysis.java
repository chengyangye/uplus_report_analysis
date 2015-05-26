package com.youjia.analysis;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.youjia.analysis.dao.impl.ReportDAO;
import com.youjia.analysis.model.ReportConstant;

public class Analysis {	

	public static void main( String args[] ) throws DataAccessException, SQLException{
/*		
        //请注意月份是从0-11
        Calendar start = Calendar.getInstance();
        start.set(2015, 3, 1);
        Calendar end = Calendar.getInstance();
        end.set(2015, 3, 28);

        while(start.compareTo(end) <= 0) {        	
    		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
    		String date = sdf.format(start.getTime());    //格式化前一天
    		System.out.println(date);
        	ClassPathXmlApplicationContext context = null;
    		try {
    			context = new ClassPathXmlApplicationContext("applicationContext-database.xml");
    			ReportDAO db = (ReportDAO) context.getBean("reportDao");
    			int text_all = db.getDailyResCountByMod(date, ReportConstant.Mod.MOD_TEXT, true);
    			int text_r = db.getDailyResCountByMod(date, ReportConstant.Mod.MOD_TEXT, false);
    			
    			int image_all = db.getDailyResCountByMod(date, ReportConstant.Mod.MOD_IMAGE, true);
    			int image_r = db.getDailyResCountByMod(date, ReportConstant.Mod.MOD_IMAGE, false);
    			
    			int audio_all = db.getDailyResCountByMod(date, ReportConstant.Mod.MOD_AUDIO, true);
    			int audio_r = db.getDailyResCountByMod(date, ReportConstant.Mod.MOD_AUDIO, false);
    			
    			int video_all = db.getDailyResCountByMod(date, ReportConstant.Mod.MOD_VIDEO, true);
    			int video_r = db.getDailyResCountByMod(date, ReportConstant.Mod.MOD_VIDEO, false);
    			
    			int punish = db.getDailyLockCount(date);
    			
    			Object[] params = {date, video_all-video_r, video_r, audio_all-audio_r, audio_r,
    					text_all-text_r, text_r, image_all-image_r, image_r, punish};
    			db.saveEveryDayPermitConut(params);
    		} finally {
    			if (context != null)
    				context.close();
    		}
            //打印每天
//            System.out.println(format.format(start.getTime()));
            //循环，每次天数加1
            start.set(Calendar.DATE, start.get(Calendar.DATE) + 1);
        }*/	
		
		Date dNow = new Date();   //当前时间
		Calendar calendar = Calendar.getInstance(); //得到日历
		calendar.setTime(dNow);//把当前时间赋给日历

		calendar.add(Calendar.DAY_OF_MONTH, -1);  //设置为前一天

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
		String date = sdf.format(calendar.getTime());    //格式化前一天
		
    	ClassPathXmlApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("applicationContext-database.xml");
			ReportDAO db = (ReportDAO) context.getBean("reportDao");
			int text_all = db.getDailyResCountByMod(date, ReportConstant.Mod.MOD_TEXT, true);
			int text_r = db.getDailyResCountByMod(date, ReportConstant.Mod.MOD_TEXT, false);
			
			int image_all = db.getDailyResCountByMod(date, ReportConstant.Mod.MOD_IMAGE, true);
			int image_r = db.getDailyResCountByMod(date, ReportConstant.Mod.MOD_IMAGE, false);
			
			int audio_all = db.getDailyResCountByMod(date, ReportConstant.Mod.MOD_AUDIO, true);
			int audio_r = db.getDailyResCountByMod(date, ReportConstant.Mod.MOD_AUDIO, false);
			
			int video_all = db.getDailyResCountByMod(date, ReportConstant.Mod.MOD_VIDEO, true);
			int video_r = db.getDailyResCountByMod(date, ReportConstant.Mod.MOD_VIDEO, false);
			
			int punish = db.getDailyLockCount(date);
			
			Object[] params = {date, video_all-video_r, video_r, audio_all-audio_r, audio_r,
					text_all-text_r, text_r, image_all-image_r, image_r, punish};
			db.saveEveryDayPermitConut(params);
		} finally {
		    if (context != null)
		    	context.close();
		}
	}
}
