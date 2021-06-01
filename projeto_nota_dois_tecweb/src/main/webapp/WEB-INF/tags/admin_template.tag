<%@ tag language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ attribute name="content" fragment="true"%>



<!DOCTYPE html>
<html lang="en">

 	<jsp:include page="/admin/template/head/head.jsp"></jsp:include>

	<body>
		<div class="wrapper">
			<jsp:include page="/admin/template/menu/menu.jsp"></jsp:include>
			
			<div class="main-panel">
				<jsp:include page="/admin/template/header/header.jsp"></jsp:include>
				
				<div class="content">
					<div class="container-fluid">
						<jsp:include page="/admin/template/cards/cards.jsp"></jsp:include>
						<jsp:invoke fragment="content"></jsp:invoke>
					</div>
				</div>
				
				<jsp:include page="/admin/template/footer/footer.jsp"></jsp:include>
				
			</div>
		</div>
		<jsp:include page="/admin/template/sidebar/sidebar.jsp"></jsp:include>
		<jsp:include page="/admin/template/js/js.jsp"></jsp:include>
	</body>
</html>