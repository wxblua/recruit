package com.recruit.dao;

import com.recruit.entity.Resume;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ResumeDao {

    /**
     * 查询简历的基本信息
     * @param id
     * @return
     */
    @Select("select * from resume where userid=#{param1} and restate=1")
    List<Resume> query(Integer id);

    /**
     * 修改姓名
     * @param name
     * @param id
     * @return
     */
    @Update("update resume set resume.rename=#{param1} where userid=#{param2} and restate=1")
    int name(String name, Integer id);

    /**
     * 修改简历的基本信息
     * @param name
     * @param sex
     * @param status
     * @param highestEducation
     * @param workYear
     * @param phone
     * @param email
     * @param id
     * @return
     */
    @Update("update resume set resume.rename=#{param1},resume.resex=#{param2},resume.jobhunter=#{param3},resume.dwelladdress=#{param4},resume.rexperience=#{param5},resume.rephone=#{param6},resume.remail=#{param7} where userid=#{param8} and restate=1")
    int basic(String name, String sex, String status, String highestEducation, String workYear, String phone, String email, Integer id);

    /**
     * 修改头像
     * @param File
     * @param id
     * @return
     */
    @Update("update resume set reimage=#{param1} where userid=#{param2} and restate=1")
    int picture(String File, Integer id);
    /*
     *
     * 添加简历的基本信息
     * @param resume
     * @return
    @Insert("insert into resume value(#{},#{},#{},#{})")
    int basicSave(Resume resume);*/


    /**
     * 查询简历所有信息
     * @return
     */
    @Select("select re.reid,re.`rename`,re.resex,re.reage,re.jobhunter,re.dwelladdress,re.rexperience,re.rephone,re.remail,re.reimage,re.restate,re.userid,re.epid,re.deliverstate,\n" +
            "it.inworknature,it.inworkaddress,it.inpositionid,it.insalary,\n" +
            "wk.wpcompanyname,wk.wpinposition,wk.wpstarttime,wk.wpstopetime,wk.wpworkdescribe,\n" +
            "pj.pjname,pj.pjstarttime,pj.pjstopetime,pj.pjdescribe,pj.pjresponsibility,\n" +
            "bd.bename,bd.beducation,bd.bemajorname,bd.bestarttime,bd.bestopetime,\n" +
            "ot.`language`,ot.insteringandspeak,ot.literacy,ot.assessment from resume re\n" +
            "left join intention it on re.reid=it.reid\n" +
            "left join workexperience wk on re.reid=wk.reid\n" +
            "left join projectperience pj on re.reid=pj.reid\n" +
            "left join backeducation bd on re.reid=bd.reid\n" +
            "left join other ot on re.reid=ot.reid where re.epid=#{epid}\n")
    public List<Map<String,Object>> queryResume(Integer epid);

    /**
     *
     * @return
     */
    @Select("select re.reid,re.`rename`,re.resex,re.reage,re.jobhunter,re.dwelladdress,re.rexperience,re.rephone,re.remail,re.reimage,re.restate,re.userid,re.epid,re.deliverstate,re.delivertime,\n" +
            "it.inworknature,it.inworkaddress,it.inpositionid,it.insalary,\n" +
            "wk.wpcompanyname,wk.wpinposition,wk.wpstarttime,wk.wpstopetime,wk.wpworkdescribe,\n" +
            "pj.pjname,pj.pjstarttime,pj.pjstopetime,pj.pjdescribe,pj.pjresponsibility,\n" +
            "bd.bename,bd.beducation,bd.bemajorname,bd.bestarttime,bd.bestopetime,\n" +
            "ot.`language`,ot.insteringandspeak,ot.literacy,ot.assessment from resume re\n" +
            "left join intention it on re.reid=it.reid\n" +
            "left join workexperience wk on re.reid=wk.reid\n" +
            "left join projectperience pj on re.reid=pj.reid\n" +
            "left join backeducation bd on re.reid=bd.reid\n" +
            "left join other ot on re.reid=ot.reid where re.userid=#{userid}")
    public List<Map<String,Object>> queryBackResume(Integer userid);

    /**
     * 根据reid查询
     * @param reid
     * @return
     */
    @Select("select re.reid,re.`rename`,re.resex,re.reage,re.jobhunter,re.dwelladdress,re.rexperience,re.rephone,re.remail,re.reimage,re.restate,re.userid,re.epid,re.deliverstate,re.delivertime,\n" +
            "it.inworknature,it.inworkaddress,it.inpositionid,it.insalary,\n" +
            "wk.wpcompanyname,wk.wpinposition,wk.wpstarttime,wk.wpstopetime,wk.wpworkdescribe,\n" +
            "pj.pjname,pj.pjstarttime,pj.pjstopetime,pj.pjdescribe,pj.pjresponsibility,\n" +
            "bd.bename,bd.beducation,bd.bemajorname,bd.bestarttime,bd.bestopetime,\n" +
            "ot.`language`,ot.insteringandspeak,ot.literacy,ot.assessment from resume re\n" +
            "left join intention it on re.reid=it.reid\n" +
            "left join workexperience wk on re.reid=wk.reid\n" +
            "left join projectperience pj on re.reid=pj.reid\n" +
            "left join backeducation bd on re.reid=bd.reid\n" +
            "left join other ot on re.reid=ot.reid where re.reid=#{reid}")
    public List<Map<String,Object>> queryById(Integer reid);

    @Update("update resume set deliverstate='投递成功' where reid=#{reid}")
    public Integer updateResume(Integer reid);
    @Update("update resume set deliverstate='被查看' where reid=#{reid}")
    public Integer updateviewed(Integer reid);
    @Update("update resume set deliverstate='通知面试' where reid=#{reid}")
    public Integer updatanotice(Integer reid);
    @Update("update resume set deliverstate='不合适' where reid=#{reid}")
    public Integer inappropriate(Integer reid);

    /*@Select("select re.reid,re.`rename`,re.resex,re.reage,re.jobhunter,re.dwelladdress,re.rexperience,re.rephone,re.remail,re.reimage,re.restate,re.userid,re.epid," +
            "wk.wpcompanyname,wk.wpinposition,wk.wpstarttime,wk.wpstopetime,wk.wpworkdescribe" +
            "from resume re" +
            "left join workexperience wk on re.reid=wk.reid")*/
    public List<Map<String,Object>> test();

    //申请职位
    @Insert("insert into resume values(#{reid},#{rename},#{resex},#{reage},#{jobhunter},#{dwelladdress},#{rexperience},#{rephone},#{remail}," +
            "#{reimage},#{restate},#{userid})")
    public int addresume(Resume resume);

    //通过用户查看是否有简历
    @Select("select * from resume where userid=#{userid}")
    public List<Map<String,Object>> querybyuid(Integer userid);

}
