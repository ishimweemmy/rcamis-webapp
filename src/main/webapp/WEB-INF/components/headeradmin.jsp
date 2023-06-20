
<%@include file="mainheader.jsp"%>
<div id="flex  w-full">
    <%@ include file="../sidebar.jsp" %>
    <div class="flex flex-col w-full md:pl-[250px] min-h-screen bg-black">
        <div class="flex bg-black w-full justify-between p-4 border-b-[1px] sticky top-0">
            <div class="flex w-full max-w-[400px] py-2 px-3 border-2 rounded-md border-white">
                <i class='bx bx-search text-2xl text-white'></i>
                <input type="text" class="w-full outline-none px-2 bg-black text-white" placeholder="Search...">
            </div>
            <div class="text-white">
                <p>${responseMessage}</p>
            </div>
            <div class="flex gap-x-4 items-center ">
                <i class='bx bxs-bell text-2xl text-white'></i>
                <div class="flex gap-x-2 items-center">
                    <i class="bx bxs-user-circle text-4xl text-white"></i>
                    <span class="flex items-center cursor-pointer text-white">
                        <c:out value="${authenticatedUser.username}"/>
                        <i class='bx bx-chevron-down text-2xl'></i>
                    </span>
                </div>
            </div>
        </div>
        <div class="flex flex-col w-full h-full p-3">
