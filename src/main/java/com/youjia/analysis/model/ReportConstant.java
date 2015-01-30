package com.youjia.analysis.model;

public class ReportConstant {

	/** 不合格：0 **/
	public static final int UNPASS = 0;
	/** 合格：1 **/
	public static final int PASS = 1;
	/** 不合格：3 自动关闭**/
	public static final int PASS_2 = 2;
    

	public static final class PunishType{
		
		/** 禁言 **/
		public static final int SILENCE = 101;
		
		/** 封号 **/
		public static final int CLOSE = 104;
		
		/** 解散群 **/
		public static final int DISMISS = 105;
		
		/** 踢人 **/
		public static final int KICKOUT = 106;
		
		/** 删资源 **/
		public static final int RMRES = 103;
		
		/** 封号 **/
		public static final int CLOSE_SHOW = 102;
		
	}

	/**
	 * 举报mod枚举( mod 为4、5、6时 mid 为群id mod 为2，3、11时 为秀场id)
	 */
	public static final class Mod {
        /**用户举报的消息*/
		/** 大厅单条消息 **/
		public static final int HALL_MSG = 11;
		/** 私聊单消息 **/
		public static final int PRIVATE_CHAT_MSG = 12;
		/** 群消息 **/
		public static final int GROUP_MSG = 13;
		/** 秀场消息 **/
		public static final int SHOW_MSG = 14;
		/** 相册 **/
		public static final int PHOTO_ALBUM = 15;
		/** 秀册 **/
		public static final int SHOW_PHOTO_ALBUM = 16;

		/** 大厅 **/
		public static final int HALL = 21;
		/** 群基本信息 **/
		public static final int GROUP_PROFILE = 22;
		/** 用户基本信息 **/
		public static final int USER_PROFILE = 23;
		/** 秀场 **/
		public static final int SHOW = 24;
		/** 私聊多条 **/
		public static final int PRIVATE_CHAT_PROFILE = 25;
		/** 群聊 */
		public static final int GROUP_CHAT_PROFILE = 26;
		
		/**上传后自动扫描资源  在页面上显示为资源审核*/
		/**视频*/
		public static final int VIDEO_PRIVATE = 303;//私聊 :303
		public static final int VIDEO_GROUP = 304;//群：304
		public static final int VIDEO_SHOW = 305;//秀场：305
		public static final int VIDEO_HALL = 306;//大厅：306
		
		/**秀场部分*/
		public static final int SHOW_PIC = 105;//秀场相册 105   显示在相册中
		public static final int SHOW_VIDEO_THUMB = 108;//秀场视频缩略图   显示在相册中
		public static final int SHOW_AUDIO = 205;//秀场音频文件
		
		/**大厅*/
		public static final int HALL_AUDIO = 206;//大厅音频文件
		
		/**私聊*/
		public static final int SILIAO_IMG = 103;//私聊图片
		public static final int SILIAO_VIDEO_IMG = 107;//私聊视频缩略图
		
		/**头像*/
		public static final int HEAD_IMG = 31;//私聊图片   1-99为纯粹的mod
		
		//资源分类
		public static final Integer[] MOD_TEXT= new Integer[]{HALL_MSG, PRIVATE_CHAT_MSG, GROUP_MSG, SHOW_MSG, HALL, GROUP_PROFILE, USER_PROFILE, SHOW, PRIVATE_CHAT_PROFILE, GROUP_CHAT_PROFILE};
		public static final Integer[] MOD_IMAGE = new Integer[]{PHOTO_ALBUM, SHOW_PHOTO_ALBUM, SHOW_PIC, SILIAO_IMG, HEAD_IMG};
		public static final Integer[] MOD_AUDIO = new Integer[]{SHOW_AUDIO,HALL_AUDIO};
		public static final Integer[] MOD_VIDEO = new Integer[]{SHOW_VIDEO_THUMB, SILIAO_VIDEO_IMG, VIDEO_PRIVATE, VIDEO_GROUP, VIDEO_SHOW, VIDEO_HALL};
	}
}
