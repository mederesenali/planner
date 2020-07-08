<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="/createNote">Create Note</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>




        <ul class="nav navbar-nav ml-auto w-100 justify-content-end">
            <form class="flex box-128" action="/logout" method="post">
                <#if _csrf??>
                    <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                </#if>
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Logout</button>
            </form>
            <li class="nav-item">
                <a class="nav-link " href="/profile">Profile</a>
            </li>

        </ul>
    </nav>
    <div class="row">


    <#list notes as note>

        <div class="card span-6"  style="width: 25rem;" id="card" >
            <div class="card-body" id="notes">
                <h5 class="card-title">${note.title}</h5>
                <#if note.done??>
                    <p class="card-text" style="text-decoration: line-through" id="note">${note.content}</p>
                <#else>
                    <p class="card-text" id="note">${note.content}</p>
                </#if>
                <p>${note.localDate}</p>
                <div class="row">
                    <div class="col">
                        <form action="/deleteNote/${note.id}" method="post">
                            <#if _csrf??>
                                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                            </#if>
                            <input class="btn btn-primary" type="submit" value="Удалить">
                        </form>
                    </div>
              <div class="col">
                  <form action="/noteDone/${note.id}" method="post">
                      <#if _csrf??>
                          <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                      </#if>
                      <input class="btn btn-primary" type="submit" value="Сделано">
                  </form>
              </div>
                <div class="cal">
                    <a href="/updateNote/${note.id}"class="btn btn-primary" >Изменить</a>
                </div>

                </div>
            </div>
        </div>
    </#list>
    </div>

</@main.renderWith>