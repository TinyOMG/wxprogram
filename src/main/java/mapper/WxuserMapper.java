package mapper;

import entity.Wxuser;

public interface WxuserMapper {
    int deleteByPrimaryKey(Integer id);
    Wxuser selectByOpenId(String openid);
    int insert(Wxuser record);
    int insertSelective(Wxuser record);

    Wxuser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Wxuser record);

    int updateByPrimaryKey(Wxuser record);
}