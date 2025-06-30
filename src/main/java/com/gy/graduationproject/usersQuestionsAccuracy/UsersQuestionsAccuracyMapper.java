package com.gy.graduationproject.usersQuestionsAccuracy;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper//声明为映射接口
public interface UsersQuestionsAccuracyMapper {
    //根据知识点获取根据知识点获取答题准确率（最近5次成绩）
    @Select("select * from users_questions_accuracy " +
            "where user_id=#{userId} and knowledge=#{knowledge} " +
            "ORDER BY create_time DESC LIMIT 5")
    List<UsersQuestionsAccuracyEntity> getAccuracyByUserIdAndKnowledge(@Param("userId") String userId,
                                                                       @Param("knowledge") String knowledge);

    //根据知识点获取根据知识点获取答题准确率（最近1次成绩）
    @Select("select * from users_questions_accuracy " +
            "where user_id=#{userId} and knowledge=#{knowledge} " +
            "ORDER BY create_time DESC LIMIT 1")
    UsersQuestionsAccuracyEntity getAccuracyByUserIdAndKnowledge1(@Param("userId") String userId,
                                                                       @Param("knowledge") String knowledge);

    //创建用户某知识点的答题准确率
    @Insert("insert into users_questions_accuracy(user_id,knowledge,accuracy,create_time) " +
            "values(#{userId},#{knowledge},#{accuracy},now())")
    void createAccuracy(@Param("userId") String userId, @Param("knowledge") String knowledge, @Param("accuracy") int accuracy);
}
