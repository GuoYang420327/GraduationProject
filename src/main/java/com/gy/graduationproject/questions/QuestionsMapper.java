package com.gy.graduationproject.questions;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper//声明为映射接口
public interface QuestionsMapper {
    //根据知识点获取题目
    @Select("select * from questions where questions.question_knowledge=#{knowledge}")
    List<QuestionsEntity> getQuestionsByKnowledge(@Param("knowledge") String knowledge);

    //新建题目
    @Insert("insert into questions(question_knowledge, question, " +
            "answer_a, answer_b, answer_c, answer_d, " +
            "right_answer, analysis) " +
            "values(#{questionKnowledge},#{question}," +
            "#{answerA},#{answerB},#{answerC},#{answerD}," +
            "#{rightAnswer},#{analysis})")
    void addQuestion(@Param("questionKnowledge") String questionKnowledge, @Param("question") String question,
                     @Param("answerA") String answerA, @Param("answerB") String answerB,
                     @Param("answerC") String answerC, @Param("answerD") String answerD,
                     @Param("rightAnswer") String rightAnswer, @Param("analysis") String analysis);

    //修改题目
    @Update("UPDATE questions SET " +
            "question_knowledge = #{questionKnowledge}, question = #{question}," +
            "answer_a = #{answerA}, answer_b = #{answerB}, answer_c = #{answerC}, answer_d = #{answerD}," +
            "right_answer = #{rightAnswer}, analysis = #{analysis} " +
            "WHERE id = #{id}")
    void updateQuestion(@Param("id") String id, @Param("questionKnowledge") String questionKnowledge,
                        @Param("question") String question,
                        @Param("answerA") String answerA, @Param("answerB") String answerB,
                        @Param("answerC") String answerC, @Param("answerD") String answerD,
                        @Param("rightAnswer") String rightAnswer, @Param("analysis") String analysis);

    //删除题目
    @Delete("delete from questions where id = #{id}")
    void deleteQuestion(@Param("id") String id);

    //删除知识点时，将对应题目的知识点设为未分配
    @Update("update questions set question_knowledge = '未分配' where question_knowledge = #{questionKnowledge}")
    void deleteQuestionKnowledge(@Param("questionKnowledge") String questionKnowledge);
}
