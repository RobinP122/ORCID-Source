<#--

    =============================================================================

    ORCID (R) Open Source
    http://orcid.org

    Copyright (c) 2012-2014 ORCID, Inc.
    Licensed under an MIT-Style License (MIT)
    http://orcid.org/open-source-license

    This copyright and license information (including a link to the full license)
    shall be included in its entirety in all copies or substantial portion of
    the software.

    =============================================================================

-->

<script type="text/ng-template" id="name-ng2-template">
    <!-- Name -->    
    <div class="workspace-section" id="names-section"> 
        <div *ngIf="!showEdit" (click)="toggleEdit()">
            <div class="row">               
                <div class="col-md-12">
                    <div class="workspace-section-title">
                        <div class="edit-name edit-option" *ngIf="!showEdit" id="open-edit-names">
                            <div class="glyphicon glyphicon-pencil">
                                <div class="popover popover-tooltip top">
                                    <div class="arrow"></div>
                                    <div class="popover-content">
                                        <span><@orcid.msg 'manage_bio_settings.editName'/></span>
                                    </div>                
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <#if !(isPublicProfile??)>
                    <h2 class="full-name" *ngIf="nameForm">
                        <span *ngIf="displayFullName()">{{nameForm?.creditName?.value}}
                        </span>
                        <span *ngIf="displayPublishedName()">
                            {{nameForm?.givenNames?.value}} <span *ngIf="nameForm?.familyName?.value != null" >{{nameForm?.familyName?.value}}</span>
                        </span>
                    </h2>
                    </#if>
                </div>
            </div>
        </div>
        <!-- Edit Mode -->
        <div class="names-edit" *ngIf="showEdit == true">

            <label for="firstName">${springMacroRequestContext.getMessage("manage_bio_settings.labelfirstname")}</label>
           
            <input type="text" [(ngModel)]="nameForm.givenNames.value" (keydown)="setNameFormEnter($event)" class="full-width-input" />
           
            <span class="orcid-error" *ngIf="nameForm.givenNames.errors.length > 0">
                <div *ngFor='let error of nameForm.givenNames.errors'>{{error}}</div>
            </span>
            <label for="lastName">${springMacroRequestContext.getMessage("manage_bio_settings.labellastname")}</label>
           
            <input type="text" [(ngModel)]="nameForm.familyName.value" (keydown)="setNameFormEnter($event)" class="full-width-input" />
           
            <label for="creditName">${springMacroRequestContext.getMessage("manage_bio_settings.labelpublishedname")}</label>                               
            <input type="text" [(ngModel)]="nameForm.creditName.value" (keydown)="setNameFormEnter($event)" class="full-width-input" />
           
            <div>
                <privacy-toggle-ng2 
                    [dataPrivacyObj]="nameForm" 
                    (privacyUpdate)="privacyChange($event)"
                    elementId="name-privacy-toggle" 
                    privacyNodeName="visibility" 
                ></privacy-toggle-ng2>

                <a href="${knowledgeBaseUri}/articles/142948-names-in-the-orcid-registry" target="142948-names-in-the-orcid-registry"><i class="glyphicon glyphicon-question-sign help-glyphicon" style="width: 14px;"></i></a>
            </div>
            <ul class="workspace-section-toolbar clearfix">
                <li class="pull-right">
                    <button class="btn btn-primary" (click)="setNameForm( true )"><@spring.message "freemarker.btnsavechanges"/></button>
                </li>
                <li class="pull-right">
                    <a class="cancel-option" (click)="cancel()"><@spring.message "freemarker.btncancel"/></a>
                </li>
            </ul>
        </div>
    </div>
</script>