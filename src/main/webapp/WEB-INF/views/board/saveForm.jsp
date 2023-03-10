<%@ page language="java" contentType="text/html; charset=UTF-16"  pageEncoding="UTF-16"%>
<!DOCTYPE html>
<%@ include file = "../layout/header.jsp"%>

<div class="container">
<form>
  <input type="hidden" name="_csrf" value="{{_csrf.token}}"/>
  <div class="form-group">
    <label for="title">제목</label>
    <input type="text"  class ="form-control"  placeholder="제목을 입력하세요" id="title" required>
  </div>
  
 <div class="form-group">
  <label for="content">내용</label>
  <textarea class="form-control summernote" rows="5" id="content"></textarea>
</div>
</form>
<button id="btn-save" class="btn btn-primary">글쓰기 완료</button>
</div>

   <script>
      $('.summernote').summernote({
        tabsize: 2,
        height: 300
      });
    </script>
<script src="/js/board.js"></script>
<%@ include file = "../layout/footer.jsp"%>
</html>