package app.yss.com.util.util.sp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import app.yss.com.util.util.LogUtil;
import app.yss.com.util.util.StringUtils;

public class SharedPreferenceUtils {




  public static final String MOREARRAY       = "morearray";
  public static final String CLASSANDSUBJECT = "classandsubject";


  public static void saveMoreArray(String[] stringArray) {

    SharePreferenceHelper.getInstance().saveStringArray(MOREARRAY, stringArray);
  }

  public static String[] getMoreArray(int arrayLength) {

    return SharePreferenceHelper.getInstance().getStringArray(MOREARRAY, arrayLength);
  }
  /**
   * // 保存List集合  SharedPreferenceUtils.saveClassAndSubject(new Gson().toJson(bean.getData()));
   */
  public static void saveClassAndSubject(String phone) {
    SharePreferenceHelper.getInstance().setStringValue(CLASSANDSUBJECT, phone);
  }

  /**
   *
   */
  public static List<ClassAndSubjectsBean> getClassAndSubject() {
    List<ClassAndSubjectsBean> listTemp = new ArrayList<>();
    try {
      String json = SharePreferenceHelper.getInstance().getStringValue(CLASSANDSUBJECT);
      if (StringUtils.isEmpty(json)){
        return listTemp;
      }
      listTemp = new Gson().fromJson(json, new TypeToken<ArrayList<ClassAndSubjectsBean>>() {
      }.getType());
    } catch (Exception e) {
      LogUtil.e(e);
    }
    return listTemp;
  }

}
