DROP TABLE IF EXISTS tbl_board_attachment;
CREATE TABLE tbl_board_attachment
(
    no           INTEGER AUTO_INCREMENT PRIMARY KEY,
    filename     VARCHAR(256) NOT NULL, -- 원본 파일 명
    path         VARCHAR(256) NOT NULL, -- 서버에서의 파일 경로 // 원본 파일 명이 겹치는 파일이 존재할 수 있으므로 구별을 위해 별도의 이름(경로) 저장
                                        -- 구별하기 위한 가장 쉬운 표기법은 이름에 타임스탬프를 찍는 것(중복이 발생할 가능성 아직 있음 ~> 희박)
    content_type VARCHAR(56),           -- content-type
    size         INTEGER,               -- 파일의 크기
    bno          INTEGER      NOT NULL, -- 게시글 번호, FK
    reg_date     DATETIME DEFAULT now(),-- 등록 날짜
    CONSTRAINT FOREIGN KEY (bno) REFERENCES tbl_board (no)
);