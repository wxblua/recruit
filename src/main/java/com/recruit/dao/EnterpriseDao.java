package com.recruit.dao;

import com.recruit.entity.Companyscale;
import com.recruit.entity.Companytype;
import com.recruit.entity.Enterprise;
import com.recruit.entity.Industrytype;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface EnterpriseDao {

    /**
     * 返回主键值
     * @param email
     * @return
     */
    @Select("select * from enterprise where epemail=#{param1}")
    public List<Map<String,Object>> searchById(String email);

    /*insert into enterprise(cyaddress,epname,originator,epemail,epphone,eppwd,ctypeid,itypeid,cpcaleid,synopsis,epstate,epimage,companyimage)VALUES('123','123','123','123','123','123',1,1,1,'123',2,'123','123')*/
    /*@Insert("insert into enterprise(cyaddress,epname,originator,epemail,epphone,eppwd,ctypeid,itypeid,cpcaleid,synopsis,epimage) values(#{cyaddress},#{epname},#{originator},#{epemail},#{epphone},#{eppwd},#{ctypeid},#{itypeid},#{cpcaleid},#{synopsis},2,#{epstate},'ep.ico')")
    public boolean addep(Enterprise enterprise);*/
    /*登录*/
    @Select("select * from enterprise where epemail=#{param1} and eppwd=#{param2}")
    public List<Enterprise> eplogin(String epemail, String eppwd);

    /*查询全部没用到*/
    /*@Select("select * from enterprise}")
    public List<Enterprise> queryById(Integer epid);*/

    /*修改公司基本信息*/
    @Update("update enterprise set epname=#{epname},originator=#{originator},epphone=#{epphone},epemail=#{epemail},eppwd=#{eppwd},cyaddress=#{cyaddress},ctypeid=#{ctypeid},itypeid=#{itypeid},cpcaleid=#{cpcaleid},synopsis=#{synopsis} where epid=#{epid}")
    public Integer updateepinfo2(Enterprise enterprise);
    /*查询企业账户信息*/
    @Select("select ent.epid,ent.cyaddress,ent.epname,ent.originator,ent.epemail,ent.epphone,ent.eppwd,cpt.ctypename,ind.itypename,csl.cpcalename,ent.synopsis,ent.epstate,ent.epimage,ent.companyimage from enterprise ent " +
            "left join companytype cpt on ent.ctypeid=cpt.ctypeid " +
            "left join industrytype ind on ent.itypeid=ind.itypeid " +
            "left join companyscale csl on ent.cpcaleid=csl.cpcaleid where ent.epid=#{epid}")
    public List<Enterprise> queryAllEnterprise(Integer epid);
    /*注册企业用户*/
    @Insert("insert into enterprise(epemail,epphone,eppwd) values(#{epemail},#{epphone},#{eppwd})")
    public boolean addepinfo(Enterprise enterprise);
    /*完善企业用户注册信息*/
    /*update enterprise set cyaddress='郑州',epname='落轩昂企业有限公司',originator='落轩',ctypeid=1,itypeid=7,cpcaleid=3,epstate=2,epimage='ep.ico' where epid=1*/
    @Update("update enterprise set cyaddress=#{cyaddress},epname=#{epname},originator=#{originator},ctypeid=#{ctypeid},itypeid=#{itypeid},cpcaleid=#{cpcaleid},epimage='ep.ico' where epemail=#{epemail}")
    public Integer updateepinfo(Enterprise enterprise);

    /*上传公司证书*/
    @Update("update enterprise set companyimage=#{param1} where epid=#{param2}")
    public Integer updateUpload(String companyimage,Integer epid);

    /*查询公司类型*/
    @Select("select * from companytype")
    public List<Companytype> queryCompanytype();
    /*查询行业类型*/
    @Select("select * from industrytype")
    public List<Industrytype> queryIndustrytype();
    /*查询公司规模*/
    @Select("select * from companyscale")
    public List<Companyscale> queryCompanyscale();
    /*修改个人资格认证*/
    @Update("update enterprise set epstate=1 where epid=#{epid}")
    public Integer updateEpstate(Integer epid);
    /*郭。。*/
    @Select("select epid,cyaddress,epname,originator,epemail,epphone,eppwd,ctypeid,itypeid," +
            "cpcaleid,epstate,companyimage from enterprise")
    public List<Map<String,Object>> queryenterprise();

}
