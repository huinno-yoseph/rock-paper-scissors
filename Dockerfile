# Python 3.9 이미지를 기반으로 생성
FROM python:3.12-slim

# 작업 디렉토리 설정
WORKDIR /app

# 필요 파일들을 복사
COPY requirements.txt requirements.txt
RUN pip install --no-cache-dir -r requirements.txt

# 애플리케이션 코드 복사
COPY . .

# 6002 포트를 컨테이너 외부에 노출
EXPOSE 6002

# Uvicorn을 사용하여 FastAPI 서버 실행
CMD ["uvicorn", "app:app", "--host", "0.0.0.0", "--port", "6002"]