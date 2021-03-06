package com.chinaboy.orm.db;

import java.util.List;

public interface DBOperateAsyncListener {
	/**
	 * database option result 
	 * @param retResult
	 * @param model
	 */
	<T extends BaseModel> void onPostExecute(DatabaseOptionType optionType, Class<T> claz, List<T> successModels, List<T> failModels);
}
