
-- 오랜 기간 보호한 동물(1)
-- LEFT JOIN을 통해서 데이터를 가져온 뒤, 그 중에서 OUTS 가 NULL 인 경우만 을 가져옴.
-- rownum 순번을 통해서 4이하인(3개만 가져옮)
SELECT * from (
    select A.NAME, A.DATETIME FROM ANIMAL_INS A 
        LEFT JOIN ANIMAL_OUTS B
        ON A.ANIMAL_ID	= B.ANIMAL_ID	
        Where B.ANIMAL_ID is null
        ORDER BY  A.DATETIME
        ) 
        where rownum < 4;
        
-- 있었는데요 없었습니다
-- JOIN 입양보낸일이 보관시작일보다 더 작은 경우를 찾음.
SELECT A.ANIMAL_ID, A.NAME from ANIMAL_INS A, ANIMAL_OUTS B
    where A.ANIMAL_ID = B.ANIMAL_ID
    AND B.DATETIME < A.DATETIME
    ORDER BY A.DATETIME        
        
