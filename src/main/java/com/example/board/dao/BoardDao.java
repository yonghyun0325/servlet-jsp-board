package com.example.board.dao;

import com.example.board.dto.BoardDto;
import com.example.board.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {

    public List<BoardDto> findAll() {

        List<BoardDto> boards = new ArrayList<>();

        String sql = """
                SELECT
                    id,
                    title,
                    content,
                    writer,
                    TO_CHAR(created_at, 'YYYY-MM-DD') AS created_at,
                    view_count
                FROM board
                ORDER BY id DESC
                """;

        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql);

                ResultSet resultSet =
                        statement.executeQuery()
        ) {

            while (resultSet.next()) {

                BoardDto board = new BoardDto(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("content"),
                        resultSet.getString("writer"),
                        resultSet.getString("created_at"),
                        resultSet.getInt("view_count")
                );

                boards.add(board);
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "게시글 목록 조회 중 오류가 발생했습니다.",
                    e
            );
        }

        return boards;
    }

    public BoardDto findById(Long id) {

        String sql = """
            SELECT
                id,
                title,
                content,
                writer,
                TO_CHAR(created_at, 'YYYY-MM-DD') AS created_at,
                view_count
            FROM board
            WHERE id = ?
            """;

        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {

                    return new BoardDto(
                            resultSet.getLong("id"),
                            resultSet.getString("title"),
                            resultSet.getString("content"),
                            resultSet.getString("writer"),
                            resultSet.getString("created_at"),
                            resultSet.getInt("view_count")
                    );
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "게시글 상세 조회 중 오류가 발생했습니다.",
                    e
            );
        }

        return null;
    }

    public void save(String title, String content, String writer) {
        String sql = """
            INSERT INTO board (
                title,
                content,
                writer
            )
            VALUES (?, ?, ?)
            """;

        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, title);
            statement.setString(2, content);
            statement.setString(3, writer);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "게시글 등록 중 오류가 발생했습니다.",
                    e
            );
        }
    }

    public void update(
            Long id,
            String title,
            String content,
            String writer
    ) {

        String sql = """
            UPDATE board
            SET
                title = ?,
                content = ?,
                writer = ?
            WHERE id = ?
            """;

        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, title);
            statement.setString(2, content);
            statement.setString(3, writer);
            statement.setLong(4, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "게시글 수정 중 오류가 발생했습니다.",
                    e
            );
        }
    }

    public void delete(Long id) {

        String sql = """
            DELETE FROM board
            WHERE id = ?
            """;

        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setLong(1, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "게시글 삭제 중 오류가 발생했습니다.",
                    e
            );
        }
    }

    public void increaseViewCount(Long id) {

        String sql = """
            UPDATE board
            SET view_count = view_count + 1
            WHERE id = ?
            """;

        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setLong(1, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "게시글 조회수 증가 중 오류가 발생했습니다.",
                    e
            );
        }
    }
}