<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="/home">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">



            </ul>

        </div>
    </nav>


    <form action="/createNote" method="post" id="postform">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>

        <div class="form-group">
            <label class="flex flex-v-center ">
                <input class="form-control mb-2" type="text" placeholder="Введите заголовок" name="title" required>
            </label>
        </div>
        <div class="form-group">
            <textarea class="form-control" id="exampleTextarea" placeholder="заметка..." name="content" rows="3" required></textarea>
        </div>
        <div class="form-group">
            <input class="form-control" type="date"  aria-placeholder="дата" placeholder="дата..." name="date" rows="3" REQUIRED>
        </div>
        <div>
            <button class="btn btn-outline-primary btn-block" type="submit">Создать!</button>
        </div>

    </form>




</@main.renderWith>